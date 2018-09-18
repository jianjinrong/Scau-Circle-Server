package com.pinnuli.service;

import com.pinnuli.model.News;
import com.pinnuli.utils.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * @description: 各网站新闻service
 * @author: pinnuli
 * @date: 2018-9-13
 */
public interface NewsService {

    List<News> queryNewsList(Integer columnId, PageUtil page, String keyword);

    News getNewsDetail(Integer nid);

}
