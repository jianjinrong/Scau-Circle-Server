package com.pinnuli.dao;

import com.pinnuli.model.Square;

import java.util.Map;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */

public interface SquareDao {

    Integer saveMessage(Square square);

    Integer updateMessageById(Square square);

    Integer setImageMessageIdBatch(Map<String, Object> parameter);

    Integer deleteMessage(int messageId);

    Integer selectColumnIdByName(String column);

    Integer checkIsContact(String column);

    Integer checkIsGoods(String column);
}
