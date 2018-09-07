package com.pinnuli.commons;

public enum ErrorCodeEnum {

    PARAMETER_ERROR(10000, "参数错误"),
    ILLEGAL_OPERATION(10001, "非法操作"),
    DB_EXCEPTION(10002, "数据库访问异常"),
    TOKEN_EXPIRED(10003, "Token超时，请重新登录"),
    TOKEN_VALID(10004, "Token校验不通过,请重新登录"),
    DB_EXIST_SAME_RECORD(10005, "新添加记录已存在"),
    BUSINESS_ERROR(10006, "业务逻辑出错");

    private Integer code;
    private String message;

    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
