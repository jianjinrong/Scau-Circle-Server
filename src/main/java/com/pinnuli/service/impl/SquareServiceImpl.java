package com.pinnuli.service.impl;

import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.dao.SquareDao;
import com.pinnuli.model.Square;
import com.pinnuli.service.SquareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */
@Service
public class SquareServiceImpl implements SquareService {

    private static Logger log = LoggerFactory.getLogger(SquareServiceImpl.class);

    @Autowired
    private SquareDao squareDao;

    @Override
    public Result save(Square square) {
        String column = square.getColumn();
        //判断消息是否需要联系方式，电话号码和微信不能同时为空
        boolean is_contact = checkIsContact(column);
        boolean lackPhone = checkIsNull(square.getPhone());
        boolean lackWechat = checkIsNull(square.getWechat());
        if (lackPhone && lackWechat && is_contact) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "手机号码和微信不能同时为空");
        }

        //判断消息是否是交易信息，交易信息需要价格
        boolean is_goods = checkIsGoods(column);
        boolean lackPrice = checkIsNull(square.getPrice());
        if(lackPrice && is_goods) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "价格不可为为空！");
        }

        //保存消息
        int saveResult;
        saveResult = squareDao.save(square);
        if (saveResult == 0) {
            return Result.createByErrorCodeEnum(ErrorCodeEnum.DB_EXCEPTION);
        }

        //判断是否有图片，有图片则设置图片所属消息id
        List<Integer> imageIdList = square.getImageIdList();
        if (imageIdList != null && imageIdList.size() > 0) {
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("imageIdList", imageIdList);
            parameter.put("messageId", square.getId());
            int setResult = setImageMessageIdBatch(parameter);
            if(setResult == 0) {
                return Result.createByErrorMessage("图片上传失败");
            }
        }
        return Result.createBySuccess();
    }

    @Override
    public Integer setImageMessageIdBatch(Map<String, Object> parameter) {
        return squareDao.setImageMessageIdBatch(parameter);
    }

    @Override
    public Integer selectColumnIdByName(String column) {
        return squareDao.selectColumnIdByName(column);
    }

//    @Override
    public <T> boolean checkIsNull(T parameter) {
        return parameter == null || "".equals(parameter.toString());
    }

    @Override
    public boolean checkIsContact(String column) {
        return squareDao.checkIsContact(column) == 1 ? true : false;
    }

    @Override
    public boolean checkIsGoods(String column) {
        return squareDao.checkIsGoods(column) == 1 ? true : false;
    }
}
