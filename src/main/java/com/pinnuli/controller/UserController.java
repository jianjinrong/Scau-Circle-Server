package com.pinnuli.controller;

import com.pinnuli.config.StatusCodeConf;
import com.pinnuli.model.User;
import com.pinnuli.service.UserService;
import com.pinnuli.utils.ExceptionStatus;
import com.pinnuli.utils.MD5Util;
import com.pinnuli.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-04
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody User user) {
        /*if ("admin".endsWith(user.getUserName().trim())) {
            return Result.error(StatusCodeConf.DATA_ERROR_CODE, "不可以注册admin用户");
        }*/
        int resultCount = userService.create(user);
        if(resultCount == 0){
            //未知错误
            return Result.error();
        }
        return Result.success("注册成功！");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        try {
            log.debug(user.getPassword());
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        Map<String, Object> result = new HashMap<>();
        result = userService.login(user);
        if(result == null){
            return Result.error(StatusCodeConf.DATA_ERROR_CODE, "请认真核对账号、密码！");
        }
        return Result.success(result);
    }



}
