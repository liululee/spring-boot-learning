package com.developlee.springbootopenapi.except;

public class BallNotFoundException extends RuntimeException {


    private String msg = "Ball Not Found";

    @Override
    public String getMessage() {
        return this.msg;
    }


}
