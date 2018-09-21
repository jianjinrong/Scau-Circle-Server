package com.pinnuli.controller;

import com.pinnuli.model.LostAndFind;
import com.pinnuli.service.LostAndFindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */
@RestController
@RequestMapping("/api/square/lost")
public class LostAndFindController {

    @Autowired
    private LostAndFindService lostAndFindService;

    private static Logger log = LoggerFactory.getLogger(ImageController.class);

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody LostAndFind lostAndFind) {
        
    }
}
