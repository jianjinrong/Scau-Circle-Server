package com.pinnuli.controller;

import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.model.Square;
import com.pinnuli.service.SquareService;
import com.sun.xml.internal.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    private static Logger log = LoggerFactory.getLogger(ImageController.class);

    @RequestMapping(value = "/{column}/create", method = RequestMethod.POST)
    public Result create(@RequestBody Square square, @PathVariable String column) {
        //判断消息是否需要联系方式，电话号码和微信不能同时为空
        boolean is_contact = squareService.checkIsContact(column);
        boolean containPhone = squareService.checkIsNotNull(square.getPhone());
        boolean containWechat = squareService.checkIsNotNull(square.getWechat());
        if (containPhone && containWechat && is_contact) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "手机号码和微信不能同时为空");
        }

        //判断消息是否是交易信息，交易信息需要价格
        boolean is_goods = squareService.checkIsGoods(column);
        boolean containPrice = squareService.checkIsNotNull(square.getPrice());
        if(containPrice && is_goods) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "价格不可为空空！");
        }

        //保存消息
        int saveResult;
        saveResult = squareService.save(square);
        if (saveResult == 0) {
            return Result.createByErrorCodeEnum(ErrorCodeEnum.DB_EXCEPTION);
        }

        //判断是否有图片，有图片则设置图片所属消息id
        List<Integer> imageIdList = square.getImageIdList();
        if (imageIdList != null && imageIdList.size() > 0) {
            squareService.setImageMessageIdBatch();
        }
        
    }
}
