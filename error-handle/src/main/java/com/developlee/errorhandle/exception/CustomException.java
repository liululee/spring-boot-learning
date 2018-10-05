package com.developlee.errorhandle.exception;

/**
 * @author Lensen
 * @desc 自定义异常类
 * @since 2018/10/5 11:04
 */
public class CustomException extends RuntimeException {

    private long code;
    private String msg;

    public CustomException(Long code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
