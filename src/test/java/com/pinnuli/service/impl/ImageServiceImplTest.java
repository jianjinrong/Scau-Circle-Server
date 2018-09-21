package com.pinnuli.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class ImageServiceImplTest {

    @Autowired
    private ImageServiceImpl imageService;

    @Test
    public void setSquareImageMid() throws Exception {
        imageService.setSquareImageMessageId(9,1);
    }

}