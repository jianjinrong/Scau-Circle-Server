package com.pinnuli.model;

import org.springframework.stereotype.Repository;

/**
 * @author: pinnuli
 * @date: 18-8-30
 */
@Repository
public class Message {
    /**
     * 主键
     */
    private String id;
    /**
     * 指令名称
     */
    private String command;
    /**
     * 描述
     */
    private String description;
    /**
     * 内容
     */
    private String contentA;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCommand() {
        return command;
    }
    public void setCommand(String command) {
        this.command = command;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContentA() {
        return contentA;
    }
    public void setContentA(String contentA) {
        this.contentA = contentA;
    }

}
