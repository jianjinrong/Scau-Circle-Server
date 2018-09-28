package com.pinnuli.dao.square;

import com.pinnuli.model.square.Message;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */

public interface MessageDao {

    Integer saveMessage(Message message);

    Integer updateMessageById(Message message);

    Integer setImageMessageIdBatch(Map<String, Object> parameter);

    Integer deleteMessage(int messageId);

    Integer selectColumnIdByName(String column);

    Integer checkIsContact(String column);

    Integer checkIsGoods(String column);

    List<Message> listMessageByColumn(Map<String, Object> parameter);
}
