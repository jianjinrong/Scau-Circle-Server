package com.pinnuli.model.image;

/**
 * @description: 用户头像实体
 * @author: pinnuli
 * @date: 2018-09-19
 */

public class UserImage extends Image{

    public UserImage() {

    }

    public UserImage(Integer userId) {
        this.userId = userId;
    }
    /**
     * 图片所属用户对应id
     */
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
