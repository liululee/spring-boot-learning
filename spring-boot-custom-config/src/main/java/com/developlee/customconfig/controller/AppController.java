package com.developlee.customconfig.controller;

import com.developlee.customconfig.config.OneAppConfig;
import com.developlee.customconfig.config.ThreeConfig;
import com.developlee.customconfig.config.TwoAppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/22 16:40
 */
@RestController
public class AppController {
    @Autowired
    private OneAppConfig oneAppConfig;
    @Autowired
    private TwoAppConfig twoAppConfig;
    @Autowired
    private ThreeConfig threeConfig;

    @GetMapping("/hello")
    public ResponseEntity getConfig() {
        String str1 = "oneAppConfig: " + oneAppConfig.getAppName() + oneAppConfig.getAccount().getUsername()
                + oneAppConfig.getAccount().getPassword() + oneAppConfig.getAccount().getAge();
        String str2 = "twoAppConfig: " + twoAppConfig.getTwoAppWelcomePerson() + twoAppConfig.getTwoAppWelcomeMessage();

        String str3 = "threeConfig: " + threeConfig.getMyName();
        return new ResponseEntity(str1 + "~~~~~~~" + str2 + "_________" + str3, HttpStatus.OK);
    }
}
