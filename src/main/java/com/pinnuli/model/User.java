package com.pinnuli.model;

import java.io.Serializable;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-04
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1361595756726482849L;

    /**
     * 用户对应id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "id: " + this.getId() + "用户：" + this.getUserName();
    }

}
