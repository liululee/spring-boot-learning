package com.linking.springsecurityremeberme.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的配置类
 */
@Configuration
@Data
public class AppConfig {
    @Value("${app.login.uri}")
    private String loginUri;

}
