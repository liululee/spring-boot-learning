package com.developlee.customconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/22 17:06
 */
@Configuration
@PropertySource("classpath:my.yml")
public class ThreeConfig {

    @Value("${my.name}")
    private String myName;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
