package com.pinnuli.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MessageDaoTest {

    @Autowired
    private MessageDao messageDao;

    @Test
    public void testQuery() {
        System.out.println(messageDao.query().size());
    }

}