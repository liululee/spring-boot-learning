package com.developlee.quartz.exception;

/**
 * @author Lensen
 * @desc 自定义异常
 * @since 2018/8/10 16:47
 */
public class QuartzException extends RuntimeException {

    private String msg;
    private int code = 500;

    public QuartzException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public QuartzException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public QuartzException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public QuartzException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}