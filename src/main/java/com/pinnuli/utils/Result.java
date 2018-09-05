package com.pinnuli.utils;


import com.pinnuli.config.StatusCodeConf;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 结果返回的模型
 * @author: pinnuli
 * @date: 18-9-3
 */

public class Result extends HashMap{


    private static final long serialVersionUID = 1L;

    /**
     * 默认返回情况
     */
    public Result() {
        put("code", StatusCodeConf.SUCCESS_CODE);
        put("message", "操作成功");
        put("content", "完全O文明K");
    }

    public static Result error() {
        return error(StatusCodeConf.UNKNOW_ERROR_CODE, "未知异常，请联系管理员");
    }

    public static Result error(String message) {
        return error(StatusCodeConf.UNKNOW_ERROR_CODE, message);
    }

    public static Result error(int code, String message) {
        Result r = new Result();
        r.put("code", code);
        r.put("message", message);
        r.put("content", "这代码有毒");
        return r;
    }

    public static Result success(String message) {
        Result r = new Result();
        r.put("message", message);
        return r;
    }

    public static Result success(Map<String, Object> map) {
        Result r = new Result();
        r.put("content", map);
        return r;
    }

    public static Result success() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
