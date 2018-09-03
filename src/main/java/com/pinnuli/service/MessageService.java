package com.pinnuli.service;

import com.pinnuli.model.Message;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-30
 */
public interface MessageService {

    public List<Message> query();
}
