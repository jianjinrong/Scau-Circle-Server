package com.pinnuli.controller;

import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.commons.ResultCodeEnum;
import com.pinnuli.dao.NewsDao;
import com.pinnuli.model.News;
import com.pinnuli.service.NewsService;
import com.pinnuli.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-13
 */
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsDao newsDao;

    //返回新闻简略信息数组
    @RequestMapping(value = "/newsList/{columnId}/{currentPage}", method = RequestMethod.GET)
    public Result queryList(@PathVariable Integer columnId,
                            @PathVariable Integer currentPage,
                            @RequestParam(name = "keyword", required = false) String keyword) {
        //创建分页对象
        PageUtil page = new PageUtil();
        if(currentPage == null){
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(currentPage);
        }
        List<News> newsList = newsService.queryNewsList(columnId, page, keyword);
        if (newsList == null) {
            return Result.createByError(ResultCodeEnum.RESULT_CODE_NOT_FOUND);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("newsList", newsList);
        data.put("page", page);
        return Result.createBySuccess(data);
    }

    //返回新闻详细信息
    @RequestMapping(value = "/detailNews/{nid}", method = RequestMethod.GET)
    public Result detailNews(@PathVariable Integer nid) {
        News news = newsService.getNewsDetail(nid);
        if (news == null) {
            return Result.createByError(ResultCodeEnum.RESULT_CODE_NOT_FOUND);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("news", news);
        return Result.createBySuccess(data);
    }


}
