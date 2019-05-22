package com.developlee.customconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/22 13:19
 */
@Configuration
public class TwoAppConfig {
    @Value("${two-app.welcome.message}")
    public String twoAppWelcomeMessage;

    @Value("${two-app.welcome.person}")
    public String twoAppWelcomePerson;

    public String getTwoAppWelcomeMessage() {
        return twoAppWelcomeMessage;
    }

    public void setTwoAppWelcomeMessage(String twoAppWelcomeMessage) {
        this.twoAppWelcomeMessage = twoAppWelcomeMessage;
    }

    public String getTwoAppWelcomePerson() {
        return twoAppWelcomePerson;
    }

    public void setTwoAppWelcomePerson(String twoAppWelcomePerson) {
        this.twoAppWelcomePerson = twoAppWelcomePerson;
    }
}
