package com.pinnuli.service.impl;

import com.pinnuli.commons.ServerResponse;
import com.pinnuli.dao.MessageDao;
import com.pinnuli.model.Message;
import com.pinnuli.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-30
 */

@Service("MessageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public ServerResponse<List<Message>> query() {

        return ServerResponse.createBySuccess(messageDao.query());
    }
}
