package com.developlee.springsocialgithub.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liululee
 * @desc
 * @since 2019/5/24 0024
 **/
@RestController
public class GithubController {

    @PostMapping("/oauth2/callback")
    public String oauthCallback() {
        return "Yes! I Got github's callback !";
    }
}
