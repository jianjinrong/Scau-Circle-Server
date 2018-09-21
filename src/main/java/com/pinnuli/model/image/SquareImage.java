package com.pinnuli.model.image;

/**
 * @description: 广场图片实体
 * @author: pinnuli
 * @date: 2018-09-19
 */

public class SquareImage extends Image{



    /**
     * 图片所属消息对应id
     */
    private Integer messageId;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
}
