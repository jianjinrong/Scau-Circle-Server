package com.pinnuli.service.impl;

import com.pinnuli.dao.NewsDao;
import com.pinnuli.model.News;
import com.pinnuli.service.NewsService;
import com.pinnuli.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-13
 */

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;


    /**
     * 新闻列表
     * @param columnId：所查官网对应的id
     * @param page：页码
     * @param keyword：搜索关键词
     * @return
     */
    @Override
    public List<News> queryNewsList(Integer columnId, PageUtil page, String keyword) {
        int totalNumber = newsDao.queryTotalNumber(columnId);
        page.setTotalNumber(totalNumber);
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("columnId", columnId);
        parameter.put("page", page);
        parameter.put("keyword", keyword);
        return newsDao.queryNewsList(parameter);
    }
}
