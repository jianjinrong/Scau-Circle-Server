package com.pinnuli.service.impl;

import com.pinnuli.commons.ConfigConsts;
import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.dao.UserDao;
import com.pinnuli.model.PayloadInfo;
import com.pinnuli.model.User;
import com.pinnuli.service.UserService;
import com.pinnuli.utils.AntiXssUtil;
import com.pinnuli.utils.JwtUtil;
import com.pinnuli.utils.MD5Util;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
        User userResult = userDao.selectByUserNameAndPassword(user);
        if (userResult == null) {
            log.debug("userResult == null");
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "密码错误！");
        } else {
            Map<String, Object> data = new HashMap<>();
            data.put("user",userResult);

            //登录成功 设置jwt
            PayloadInfo payloadInfo = new PayloadInfo();
            payloadInfo.setUid(userResult.getUid());
            payloadInfo.setUserName(userResult.getUserName());

            try {
                String jwt = JwtUtil.createJWT("jwt", "", ConfigConsts.TOKEN_LIFECYCLE, payloadInfo);
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
    public Result<Map<String, Object>> logout(PayloadInfo payloadInfo) {
        log.debug("用户名：{}", payloadInfo.getUserName() );
        User userResult = userDao.selectByUserName(payloadInfo.getUserName());
        Map<String, Object> data = new HashMap<>();
        data.put("user",userResult);
        //设置过期的jwt并返回
        try {
            String jwt = JwtUtil.createJWT("jwt", "", 0, payloadInfo);
            data.put("token", jwt);
            return Result.createBySuccess(data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Result.createByError();
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

    @Override
    public Result<Map<String, Object>> resetPassword(PayloadInfo payloadInfo, String oldPassword, String newPassword) {

        String MD5OldPassword = MD5Util.MD5Encode(oldPassword, "utf-8");
        Integer uid = payloadInfo.getUid();
        User user = new User();
        user.setUid(uid);
        user.setPassword(MD5OldPassword);
        log.debug("旧密码：{}", oldPassword);
        //校验旧密码
        int resultCount = userDao.checkPassword(user);
        if(resultCount == 0 ) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "旧密码错误！");
        }
        //旧密码校验通过，更新密码
        String MD5NewPassword = MD5Util.MD5Encode(newPassword, "utf-8");
        user.setPassword(MD5NewPassword);
        int updateCount = userDao.updatePasswordByUserName(user);
        if (updateCount == 0) {
            return Result.createByErrorCodeEnum(ErrorCodeEnum.DB_EXCEPTION);
        }
        return Result.createBySuccessMessage("密码重置成功！");
    }

    @Override
    public PayloadInfo getPayloadInfo(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        String currentUserName = request.getHeader("currentUserName");
        PayloadInfo payloadInfo = new PayloadInfo();
        if(!jwt.isEmpty() && !currentUserName.isEmpty()) {
            try {
                Claims claims = JwtUtil.parseJWT(jwt);
                payloadInfo.setUid(Integer.parseInt(claims.get("uid").toString()));
                payloadInfo.setUserName(claims.get("userName").toString());
                return payloadInfo;
            } catch (Exception e) {
                log.info("token解析异常");
                return null;
            }
        } else {
            return null;
        }
    }


}
