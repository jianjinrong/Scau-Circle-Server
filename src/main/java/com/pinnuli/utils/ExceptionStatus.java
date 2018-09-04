package com.pinnuli.utils;

import com.pinnuli.config.StatusCodeConf;

/**
 * @description: 枚举类型
 * @author: pinnuli
 * @date: 2018-09-04
 */

public enum ExceptionStatus {

    /**
     *操作成功时返回码和信息
     */
    SUCCESS(StatusCodeConf.SUCCESS_CODE, "成功"),

    /**
     * 操作失败时返回码和信息
     */
    ERROR(StatusCodeConf.ERROR_CODE, "失败");

    public static final String OK_MESSAGE = "完全O文明K";
    public static final String ERROR_MESSAGE = "这代码有毒";
    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    private ExceptionStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
