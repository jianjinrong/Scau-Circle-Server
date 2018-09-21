package com.pinnuli.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 公告实体类
 * @author: pinnuli
 * @date: 2018-09-21
 */

public class Notice implements Serializable{

    private static final long serialVersionUID = 1833770615781851765L;
    /**
     * 公告索引id
     */
    private Integer id;

    /**
     * 公告发布人的索引id
     */
    private Integer uid;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 公告点击量
     */
    private Integer clickTimes;

    /**
     * 公告发布时间
     */
    private Date createTime;

    /**
     * 公告修改时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
