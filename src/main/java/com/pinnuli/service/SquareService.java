package com.pinnuli.service;

import com.pinnuli.commons.Result;
import com.pinnuli.model.Square;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */
public interface SquareService {

    /**
     * 保存广场消息
     * @param square 需要保存的消息
     * @return 返回影响数据库行数
     */
    Result save(Square square);

    Integer setImageMessageIdBatch(Map<String, Object> parameter);

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
