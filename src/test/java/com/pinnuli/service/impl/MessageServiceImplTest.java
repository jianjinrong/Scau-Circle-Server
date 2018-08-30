package com.pinnuli.service.impl;

import com.pinnuli.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class MessageServiceImplTest {


    @Autowired
    private MessageService messageService;


    @Test
    public void testQuery() throws Exception {

        System.out.println(messageService.query());

    }
}