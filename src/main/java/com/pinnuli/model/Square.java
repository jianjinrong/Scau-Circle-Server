package com.pinnuli.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */

public class Square implements Serializable {

    private static final long serialVersionUID = -7079996901269289884L;

    /**
     * 消息索引id
     */
    private Integer id;

    /**
     * 消息所属栏目id
     */
    private Integer squareId;

    /**
     * 消息发布人id
     */
    private Integer userId;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息图片的id列表
     */
    private List<Integer> imageIdList;

    /**
     * 联系人手机号码
     */
    private Long phone;


    /**
     * 联系人微信
     */
    private String wechat;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 点击量
     */
    private Integer clickTimes;

    /**
     * 消息状态，1表示失效，0表示有效
     */
    private Integer status;

    /**
     * 软删除，1表示未删除，0表示已删除
     */
    private Integer isDelete;

    /**
     * 消息发布时间
     */
    private Date createTime;

    /**
     * 消息修改时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSquareId() {
        return squareId;
    }

    public void setSquareId(Integer squareId) {
        this.squareId = squareId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(Integer clickTimes) {
        this.clickTimes = clickTimes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public List<Integer> getImageIdList() {
        return imageIdList;
    }

    public void setImageIdList(List<Integer> imageIdList) {
        this.imageIdList = imageIdList;
    }

}
