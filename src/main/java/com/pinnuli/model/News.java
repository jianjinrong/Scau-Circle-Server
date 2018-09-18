package com.pinnuli.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 各官网新闻类
 * @author: pinnuli
 * @date: 2018-09-13
 */

public class News implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 新闻id
     */
    Integer nid;

    /**
     * 新闻对应原文链接
     */
    String url;

    /**
     * 新闻标题
     */
    String title;


    /**
     * 新闻标签
     */
    String label;

    /**
     * 新闻发布时间
     */
    Date pubDate;

    /**
     * 点击量
     */
    int clickTimes;

    /**
     * 新闻内容
     */
    String content;

    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 修改时间
     */
    Date updateTime;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public int getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
