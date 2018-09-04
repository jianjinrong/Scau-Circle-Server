package com.pinnuli.controller;

import com.pinnuli.service.UserService;
import com.pinnuli.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public Result create(@RequestParam("userName") String userName,
                         @RequestParam("password") String password) {
        log.debug(userName);
        userService.create(userName, password);
        return Result.SUCCESS();
    }
}
