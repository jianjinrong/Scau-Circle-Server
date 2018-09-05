package com.pinnuli.service.impl;

import com.pinnuli.dao.UserDao;
import com.pinnuli.model.User;
import com.pinnuli.service.UserService;
import com.pinnuli.utils.AntiXssUtil;
import com.pinnuli.utils.JWTUtil;
import com.pinnuli.utils.MD5Util;
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

    @Autowired
    private UserDao userDao;

    @Override
    public int create(User user) {
        user.setPassword(MD5Util.MD5Encode(user.getPassword(), "UTF-8"));
        user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
        return userDao.create(user);
    }

    @Override
    public Map<String, Object> login(User user) {
        Map<String, Object> content = new HashMap<>();
        User userResult = userDao.login(user);
        if (userResult == null) {
            return null;
        } else {
            content.put("user",userResult);
            //登录成功 设置jwt
            JWTUtil util = new JWTUtil();
            //设置信息
            Map<String, Object> payload = new HashMap<String, Object>();
            payload.put("user_id", userResult.getUid());
            try {
                String jwt = util.createJWT("jwt", "", 600000, payload);
                content.put("token", jwt);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
    }

}
