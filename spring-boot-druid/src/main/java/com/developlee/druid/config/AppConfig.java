package com.developlee.druid.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/26 21:08
 */
@Configuration
@Data
public class AppConfig {
    @Value("${app.druid.username}")
    private String druidUserName;
    @Value("${app.druid.password}")
    private String druidPassword;
    @Value("${app.druid.reset-all}")
    private String druidResetAll;
}
