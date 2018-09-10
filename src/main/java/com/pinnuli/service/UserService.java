package com.pinnuli.service;

import com.pinnuli.commons.Result;
import com.pinnuli.model.User;

import java.util.Map;

/**
 * @author: pinnuli
 * @date: 18-9-4
 */

public interface UserService {


    /**
     * @description 注册用户
     * @param user
     * @return 返回操作数据库受影响的行数
     */
    Result<String> save(User user);

    Result<Map<String, Object>> login(User user);

    Result<Map<String, Object>> logout(User user);

    Result<String> checkUserName(String userName);

}
