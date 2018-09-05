package com.pinnuli.service;

import com.pinnuli.model.User;

import java.util.Map;

/**
 * @author: pinnuli
 * @date: 18-9-4
 */

public interface UserService {


    /**
     * @param user
     * @return
     */
    public int create(User user);

    public Map<String, Object> login(User user);

}
