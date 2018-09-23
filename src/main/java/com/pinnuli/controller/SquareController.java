package com.pinnuli.controller;

import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.model.PayloadInfo;
import com.pinnuli.model.Square;
import com.pinnuli.service.SquareService;
import com.pinnuli.service.UserService;
import com.sun.xml.internal.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Result create(@RequestBody Square square, HttpServletRequest request) {
        //设置用户id
        PayloadInfo payloadInfo = userService.getPayloadInfo(request);
        square.setUserId(payloadInfo.getUserId());
        return squareService.save(square);
    }
}
