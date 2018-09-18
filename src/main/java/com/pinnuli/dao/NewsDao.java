package com.pinnuli.dao;

import com.pinnuli.model.News;

import java.util.List;
import java.util.Map;

/**
 * @description: 新闻数据库操作
 * @author: pinnuli
 * @date: 2018-09-13
 */

public interface NewsDao {

    /**
     * 返回该类新闻总条数
     * @param columnId
     * @return
     */
    int queryTotalNumber(int columnId);

    /**
     * 按参数查询返回新闻列表
     * @param parameter:查询的参数
     * @return
     */
    List<News> queryNewsList(Map<String, Object> parameter);


    /**
     * 让新闻的点击量加一
     * @param nid
     */
    void addNewsClickTimes(Integer nid);

    /**
     * 根据新闻id返回新闻详细信息
     * @param nid
     * @return
     */
    News selectNewsByNid(Integer nid);

}
