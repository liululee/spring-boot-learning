package com.developlee.demospringbootstarter.service;

/**
 * @author Lee
 * @// TODO 2018/7/10-14:44
 * @description
 */
public class HelloService {

    private String msg;

    private String sayHello() {
        return "Hello" + msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
