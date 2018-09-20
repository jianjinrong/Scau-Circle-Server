package com.pinnuli.model.image;

/**
 * @description: 用户头像实体
 * @author: pinnuli
 * @date: 2018-09-19
 */

public class UserImage extends Image{

    /**
     * 图片所属用户对应id
     */
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
