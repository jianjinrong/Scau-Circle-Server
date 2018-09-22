package com.pinnuli.service.impl;

import com.pinnuli.dao.SquareDao;
import com.pinnuli.model.Square;
import com.pinnuli.service.SquareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */
@Service
public class SquareServiceImpl<T> implements SquareService<T> {

    private static Logger log = LoggerFactory.getLogger(SquareServiceImpl.class);

    @Autowired
    private SquareDao squareDao;

    @Override
    public Integer save(Square square) {
        return squareDao.save(square);
    }

    @Override
    public boolean checkIsNotNull(T parameter) {
        return parameter != null && "".equals(parameter.toString());
    }

    @Override
    public boolean checkIsContact(String column) {
        return squareDao.checkIsContact(column) == 1 ? true : false;
    }

    @Override
    public boolean checkIsGoods(String column) {
        return squareDao.checkIsGoods(column) == 1 ? true : false;
    }
}
