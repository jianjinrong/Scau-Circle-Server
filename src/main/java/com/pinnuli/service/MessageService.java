package com.pinnuli.service;

import com.pinnuli.commons.ServerResponse;
import com.pinnuli.model.Message;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-30
 */
public interface MessageService {

    public ServerResponse<List<Message>> query();
}
