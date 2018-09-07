package com.pinnuli.controller;

import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.config.StatusCodeConf;
import com.pinnuli.model.User;
import com.pinnuli.service.UserService;
import com.pinnuli.utils.MD5Util;
import com.pinnuli.commons.Result;
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
    public Result<String> create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    /*@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Result logout(){
        return userService;
    }*/

}
