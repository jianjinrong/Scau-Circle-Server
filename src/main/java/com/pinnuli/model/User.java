package com.pinnuli.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-04
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户对应id
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "id: " + this.getUid() + "用户：" + this.getUserName();
    }

}
