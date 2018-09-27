package com.pinnuli.controller;

import com.pinnuli.commons.Result;
import com.pinnuli.model.PayloadInfo;
import com.pinnuli.model.Square;
import com.pinnuli.service.SquareService;
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
public class SquareController {

    @Autowired
    private SquareService squareService;

    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(ImageController.class);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveMessage(@RequestBody Square square, HttpServletRequest request) {
        //设置用户id
        PayloadInfo payloadInfo = userService.getPayloadInfo(request);
        square.setUserId(payloadInfo.getUserId());
        return squareService.saveOrUpdateMessage(square);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteMessage(@RequestParam("messageId") Integer messageId) {
        return squareService.deleteMessage(messageId);
    }
}
