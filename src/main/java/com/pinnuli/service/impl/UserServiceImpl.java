package com.pinnuli.service.impl;

import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.dao.UserDao;
import com.pinnuli.model.User;
import com.pinnuli.service.UserService;
import com.pinnuli.utils.AntiXssUtil;
import com.pinnuli.utils.JwtUtil;
import com.pinnuli.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: UserService实现类
 * @author: pinnuli
 * @date: 2018-09-04
 */
@Service
public class UserServiceImpl implements UserService{

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Result<String> save(User user) {
        Result validUserName = checkUserName(user.getUserName());
        if(!validUserName.isSuccess()){
            return validUserName;
        }
        log.debug("密码:" + user.getPassword());
        user.setPassword(MD5Util.MD5Encode(user.getPassword(), "UTF-8"));
        user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
        int resultCount = userDao.save(user);
        if(resultCount == 0){
            //未知错误
            return Result.createByErrorMessage("注册失败！");
        }
        return Result.createBySuccessMessage("注册成功");
    }

    @Override
    public Result<Map<String, Object>> login(User user) {
        //检查用户是否存在
        int resultCount = userDao.checkUserName(user.getUserName());
        if(resultCount == 0){
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "用户不存在！");
        }

        //检查密码
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        User userResult = userDao.login(user);
        if (userResult == null) {
            log.debug("userResult == null");
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "密码错误！");
        } else {
            Map<String, Object> data = new HashMap<>();
            data.put("user",userResult);

            //登录成功 设置jwt
            JwtUtil util = new JwtUtil();
            //设置信息,这里只设置了user_id
            Map<String, Object> payload = new HashMap<String, Object>();
            payload.put("user_id", userResult.getUid());
            try {
                String jwt = util.createJWT("jwt", "", 30000, payload);
                data.put("token", jwt);
                return Result.createBySuccess(data);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return Result.createByError();
        }
    }

    @Override
    public Result<String> checkUserName(String userName) {
        if (userName.trim().endsWith("admin")) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "不能添加admin用户");
        }

        int resultCount = userDao.checkUserName(userName);
        if(resultCount > 0) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "用户名已存在");
        }

        return Result.createBySuccess("校验成功！");
    }

}
