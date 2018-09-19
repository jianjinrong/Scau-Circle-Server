package com.pinnuli.model.image;

/**
 * @description: 上传图片接口
 * @author: pinnuli
 * @date: 2018-09-19
 */
public interface Image {
    Integer getImageId();

    void setImageId(Integer imageId);

    String getRealPath();

    void setRealPath(String realPath);

    String getWebPath();

    void setWebPath(String webPath);

}
