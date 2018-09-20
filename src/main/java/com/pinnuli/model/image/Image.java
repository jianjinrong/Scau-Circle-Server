package com.pinnuli.model.image;

/**
 * @description: 上传图片接口
 * @author: pinnuli
 * @date: 2018-09-19
 */
public class Image {
    /**
     * 图片对应id
     */
    protected Integer imageId;

    /**
     * 图片真实路径
     */
    protected String realPath;

    /**
     * 图片相对路径
     */
    protected String webPath;

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

}
