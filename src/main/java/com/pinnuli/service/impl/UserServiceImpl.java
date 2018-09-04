package com.pinnuli.service.impl;

import com.pinnuli.dao.UserDao;
import com.pinnuli.model.User;
import com.pinnuli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-04
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User create(String userName, String password) {
        return userDao.create(userName, password);
    }

}
