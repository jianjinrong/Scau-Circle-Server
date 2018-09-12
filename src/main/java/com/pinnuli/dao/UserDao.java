package com.pinnuli.dao;

import com.pinnuli.model.User;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-9-4
 */
public interface UserDao {

    int save(User user);

    User selectByUserName(String userName);

    User selectByUserNameAndPassword(User user);

    int checkUserName(String userName);

    int checkPassword(User user);

    int updatePasswordByUserName(User user);

}
