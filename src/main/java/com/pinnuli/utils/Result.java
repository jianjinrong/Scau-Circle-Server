package com.pinnuli.utils;


/**
 * @description: 结果返回的模型
 * @author: pinnuli
 * @date: 18-9-3
 */

public class Result {


    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回内容
     */
    private Object content;

    public Result() {

    }

    public Result(Integer code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public Result(ExceptionStatus exceptionStatus, Object content){
        this.code = exceptionStatus.getCode();
        this.message = exceptionStatus.getMessage();
        this.content = content;
    }

    public static Result SUCCESS( Object content){
        return new Result(ExceptionStatus.SUCCESS, content);
    }

    public static Result SUCCESS(){
        return new Result(ExceptionStatus.SUCCESS, ExceptionStatus.OK_MESSAGE);
    }

   /* public static Result ERROR(BaseException e){
        return new Result(e.getCode(), e.getMessage(), e.getClass().getSimpleName());
    }*/

    public static Result ERROR(ExceptionStatus exceptionStatus){
        return new Result(exceptionStatus, ExceptionStatus.ERROR_MESSAGE);
    }

    public static Result ERROR(){
        return new Result(ExceptionStatus.ERROR, ExceptionStatus.ERROR_MESSAGE);
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getContent() {
        return content;
    }
}
