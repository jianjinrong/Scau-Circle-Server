package com.pinnuli.service.impl.square;

import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.dao.ImageDao;
import com.pinnuli.dao.square.MessageDao;
import com.pinnuli.model.square.Message;
import com.pinnuli.service.square.MessageService;
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
public class MessageServiceImpl implements MessageService {

    private static Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private ImageDao imageDao;

    @Override
    public Result saveOrUpdateMessage(Message message) {
        String column = message.getColumn();
        //判断消息是否需要联系方式，电话号码和微信不能同时为空
        boolean is_contact = checkIsContact(column);
        boolean lackPhone = checkIsNull(message.getPhone());
        boolean lackWechat = checkIsNull(message.getWechat());
        if (lackPhone && lackWechat && is_contact) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "手机号码和微信不能同时为空");
        }

        //判断消息是否是交易信息，交易信息需要价格
        boolean is_goods = checkIsGoods(column);
        boolean lackPrice = checkIsNull(message.getPrice());
        if(lackPrice && is_goods) {
            return Result.createByErrorCodeMessage(ErrorCodeEnum.PARAMETER_ERROR.getCode(), "价格不可为为空！");
        }

        //保存消息
        int result = 0;
        if(message.getId() == null) {
            result = messageDao.saveMessage(message);
        } else {
            result = messageDao.updateMessageById(message);
        }
        if (result == 0) {
            return Result.createByErrorCodeEnum(ErrorCodeEnum.DB_EXCEPTION);
        }

        //判断是否有图片，有图片则设置图片所属消息id
        List<Integer> imageIdList = message.getImageIdList();
        if (imageIdList != null && imageIdList.size() > 0) {
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("imageIdList", imageIdList);
            parameter.put("messageId", message.getId());
            int setResult = setImageMessageIdBatch(parameter);
            if(setResult == 0) {
                return Result.createByErrorMessage("图片上传失败");
            }
        }
        return Result.createBySuccess();
    }

    @Override
    public Result deleteMessage(int messageId) {
        int deleteResult = messageDao.deleteMessage(messageId);
        if(deleteResult > 0) {
            imageDao.deleteSquareImageBatch(messageId);
            return Result.createBySuccess();
        }
        return Result.createByError();

    }

    @Override
    public Integer setImageMessageIdBatch(Map<String, Object> parameter) {
        return messageDao.setImageMessageIdBatch(parameter);
    }

    @Override
    public Integer selectColumnIdByName(String column) {
        return messageDao.selectColumnIdByName(column);
    }

//    @Override
    public <T> boolean checkIsNull(T parameter) {
        return parameter == null || "".equals(parameter.toString());
    }

    @Override
    public boolean checkIsContact(String column) {
        return messageDao.checkIsContact(column) == 1 ? true : false;
    }

    @Override
    public boolean checkIsGoods(String column) {
        return messageDao.checkIsGoods(column) == 1 ? true : false;
    }
}
