package com.pinnuli.dao;

import com.pinnuli.model.User;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-9-4
 */
public interface UserDao {

    int save(User user);

    User login(User user);

    int checkUserName(String userName);

}
