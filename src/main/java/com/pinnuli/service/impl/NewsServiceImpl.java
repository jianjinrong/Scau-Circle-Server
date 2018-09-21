package com.pinnuli.service.impl;

import com.pinnuli.dao.NewsDao;
import com.pinnuli.dao.UserDao;
import com.pinnuli.model.News;
import com.pinnuli.service.NewsService;
import com.pinnuli.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<News> newsList = new ArrayList<>();
        newsList = newsDao.queryNewsList(parameter);
        //新闻内容提取简略信息
        for (News news: newsList) {
            news.setContent(news.getContent().substring(0,300));
        }
        return newsList;
    }

    @Override
    public News getNewsDetail(Integer newsId) {
        //新闻的点击量加一
        newsDao.addNewsClickTimes(newsId);
        return newsDao.selectNewsByNid(newsId);
    }
}
