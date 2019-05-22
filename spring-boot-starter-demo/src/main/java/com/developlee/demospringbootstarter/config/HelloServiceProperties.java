package com.developlee.demospringbootstarter.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Lee
 * @// TODO 2018/7/10-14:42
 * @description
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
