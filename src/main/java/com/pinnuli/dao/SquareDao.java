package com.pinnuli.dao;

import com.pinnuli.model.Square;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */

public interface SquareDao {

    int save(Square square);

    int checkIsContact(String column);

    int checkIsGoods(String column);
}
