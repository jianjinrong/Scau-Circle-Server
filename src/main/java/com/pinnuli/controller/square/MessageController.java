package com.pinnuli.controller.square;

import com.pinnuli.commons.Result;
import com.pinnuli.controller.ImageController;
import com.pinnuli.model.square.Message;
import com.pinnuli.model.PayloadInfo;
import com.pinnuli.service.square.MessageService;
import com.pinnuli.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */
@RestController
@RequestMapping("/api/square")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(ImageController.class);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveMessage(@RequestBody Message message, HttpServletRequest request) {
        //设置用户id
        PayloadInfo payloadInfo = userService.getPayloadInfo(request);
        message.setUserId(payloadInfo.getUserId());
        return messageService.saveOrUpdateMessage(message);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteMessage(@RequestParam("messageId") Integer messageId) {
        return messageService.deleteMessage(messageId);
    }


}
