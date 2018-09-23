package com.pinnuli.dao;

import com.pinnuli.model.Square;

import java.util.Map;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */

public interface SquareDao {

    int save(Square square);

    int setImageMessageIdBatch(Map<String, Object> parameter);

    int selectColumnIdByName(String column);

    int checkIsContact(String column);

    int checkIsGoods(String column);
}
