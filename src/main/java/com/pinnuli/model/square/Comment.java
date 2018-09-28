package com.pinnuli.model.square;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-28
 */

public class Comment implements Serializable {

    private static final long serialVersionUID = -547795718984111676L;

    /**
     * 评论id
     */
    private Integer id;
    /**
     * 评论所属消息id
     */
    private Integer messageId;
    /**
     * 评论发表人员id
     */
    private Integer userId;
    /**
     * 评论发表人员用户名
     */
    private String userName;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论的赞个数
     */
    private Integer likeCount;
    /**
     * 评论发表时间
     */
    private Date pubTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }
}
