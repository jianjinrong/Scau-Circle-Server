package com.pinnuli.config;

/**
 * @description: 返回码配置
 * @author: pinnuli
 * @date: 18-9-4
 */

public class StatusCodeConf {

    private StatusCodeConf(){
        throw new AssertionError();
    }

    /**
     * 成功
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * token错误
     */
    public static final int TOKEN_ERROR_CODE = -200;

    /**
     * headers 缺少authorization头
     */
    public static final int AUTHORIZATION_NOTFOUND_CODE = -201;

    /**
     * token超时
     */
    public static final int TOKEN_EXPIRED_CODE = -202;

    /**
     * 操作失败
     */
    public static final int ACTION_FAIL_CODE = -203;

    /**
     * 系统错误
     */
    public static final int ERROR_CODE = -300;

    /**
     * 权限错误
     */
    public static final int AUTHORITY_ERROR_CODE = -303;

    /**
     * 操作不允许
     */
    public static final int FORBIDDEN_CODE = -400;

    /**
     * 数据错误
     */
    public static final int DATA_ERROR_CODE = -401;

    /**
     * 资源不存在
     */
    public static final int RESOURCE_NOTFOUND_CODE = -404;

    /**
     * 未知错误
     */
    public static final int UNKNOW_ERROR_CODE = 500;
}
