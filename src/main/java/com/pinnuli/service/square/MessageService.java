package com.pinnuli.service.square;

import com.pinnuli.commons.Result;
import com.pinnuli.model.square.Message;

import java.util.Map;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */
public interface MessageService {

    /**
     * 保存广场消息
     * @param message 需要保存的消息
     * @return 返回影响数据库行数
     */
    Result saveOrUpdateMessage(Message message);


    /**
     * 删除广场消息，软删除
     * @param messageId 消息id
     * @return 返回操作结果
     */
    Result deleteMessage(int messageId);

    /**
     * 批量设置广场消息所带图片的消息id
     * @param parameter 包括图片id的列表和消息的id
     * @return 返回影响行数
     */
    Integer setImageMessageIdBatch(Map<String, Object> parameter);

    /**
     * 根据广场栏目名称获取其id
     * @param column 广场栏目名称
     * @return 返回栏目id
     */
    Integer selectColumnIdByName(String column);


    /**
     * 校验某参数是否为空
     * @param parameter 要校验的参数
     * @return 检验结果
     */
//    boolean checkIsNull(T parameter);

    /**
     * 校验是否需要联系信息
     * @param column 广场栏目名称
     * @return 检验结果
     */
    boolean checkIsContact(String column);

    /**
     * 校验是否为交易信息
     * @param column 广场栏目名称
     * @return 检验结果
     */
    boolean checkIsGoods(String column);



}
