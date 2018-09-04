package com.pinnuli.dao;

import com.pinnuli.model.User;

/**
 * @author: pinnuli
 * @date: 18-9-4
 */
public interface UserDao {

    public User create(String userName, String password);
}
