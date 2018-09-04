package com.pinnuli.controller;

import com.pinnuli.model.Message;
import com.pinnuli.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-30
 */

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /*@RequestMapping(value = "query", method = RequestMethod.GET)
    public Result query() {
        System.out.println("query");
        List<Message> list = messageService.query();
        return Result.ok().put("list", list);
    }*/

}
