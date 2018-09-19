package com.pinnuli.model.image;

/**
 * @description: 用户头像实体
 * @author: pinnuli
 * @date: 2018-09-19
 */

public class UserImage implements Image{

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
     * 图片所属用户对应id
     */
    private Integer uid;

    @Override
    public Integer getImageId() {
        return imageId;
    }

    @Override
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @Override
    public String getRealPath() {
        return realPath;
    }

    @Override
    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    @Override
    public String getWebPath() {
        return webPath;
    }

    @Override
    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
