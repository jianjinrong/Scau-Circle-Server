package com.pinnuli.model.image;

import java.io.Serializable;

/**
 * @description: 上传图片接口
 * @author: pinnuli
 * @date: 2018-09-19
 */

public class Image implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 图片对应id
     */
    protected Integer id;

    /**
     * 图片真实路径
     */
    protected String realPath;

    /**
     * 图片相对路径
     */
    protected String webPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
