package com.pinnuli.service.impl;

import com.pinnuli.dao.LostAndFindDao;
import com.pinnuli.model.LostAndFind;
import com.pinnuli.service.LostAndFindService;
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
public class LostAndFindServiceImpl implements LostAndFindService {

    private static Logger log = LoggerFactory.getLogger(LostAndFindServiceImpl.class);

    @Autowired
    private LostAndFindDao lostAndFindDao;

    @Override
    public Integer save(LostAndFind lostAndFind) {
        return LostAndFindDao.save(lostAndFind);
    }
}
