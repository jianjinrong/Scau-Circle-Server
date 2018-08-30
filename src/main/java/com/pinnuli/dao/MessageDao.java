package com.pinnuli.dao;

import com.pinnuli.model.Message;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-30
 */
public interface MessageDao {

    public List<Message> query();

}
