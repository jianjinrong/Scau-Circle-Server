package com.pinnuli.service;

import com.pinnuli.model.User;

/**
 * @author: pinnuli
 * @date: 18-9-4
 */

public interface UserService {


    /**
     * @param userName: 用户名
     * @param password： 密码
     * @return User
     */
    public User create(String userName, String password);

}
