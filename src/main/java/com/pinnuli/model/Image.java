package com.pinnuli.model;

import java.io.Serializable;

/**
 * @description: 图片实体
 * @author: pinnuli
 * @date: 2018-09-18
 */

public class Image implements Serializable {

    /**
     * 图片对应id
     */
    private Integer imageId;

    /**
     * 图片真实路径
     */
    private String realPath;

    /**
     * 图片相对路径
     */
    private String webPath;

    /**
     * 图片所属消息对应id
     */
    private Integer mid;


    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    public String getWebPath() {
        return webPath;
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}
