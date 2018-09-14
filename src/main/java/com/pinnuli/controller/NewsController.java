package com.pinnuli.controller;

import com.pinnuli.commons.Result;
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

    //匹配页数个数是否正确
    private Pattern pattern = Pattern.compile("[0-9]{0,9}");

    @RequestMapping(value = "/newsList/{columnId}/{currentPage}", method = RequestMethod.GET)
    public Result queryList(@PathVariable Integer columnId,
                            @PathVariable Integer currentPage,
                            @RequestParam(name = "keyword", required = false) String keyword) {
        //创建分页对象
        PageUtil page = new PageUtil();
        if(currentPage == null || !pattern.matcher(currentPage.toString()).matches()){
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(currentPage);
        }
        List<News> newsList = newsService.queryNewsList(columnId, page, keyword);
        Map<String, Object> data = new HashMap<>();
        data.put("newsList", newsList);
        data.put("page", page);
        return Result.createBySuccess(data);
    }
}
