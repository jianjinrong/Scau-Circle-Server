package com.pinnuli.dao;

import com.pinnuli.model.User;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-9-4
 */
public interface UserDao {

    public int create(User user);

    public User login(User user);
}
