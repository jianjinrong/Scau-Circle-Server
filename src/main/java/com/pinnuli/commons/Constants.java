package com.pinnuli.commons;

/**
 * @author: pinnuli
 * @date: 18-9-3
 */

public class Constants {

    public static final int RESULT_CODE_SUCCESS = 200;  // 成功处理请求
    public static final int RESULT_CODE_BAD_REQUEST = 412;  // bad request
    public static final int RESULT_CODE_SERVER_ERROR = 500;  // 没有对应结果

    public static final String ARTICLE_CACHE_KEY = "ssm-cluster:article:";//文章key
    public static final String PICTURE_CACHE_KEY = "ssm-cluster:picture:";//图片key
}
