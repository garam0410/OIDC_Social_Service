package com.oidc.social.controller;

import com.oidc.social.dao.SocialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages="com.oidc.social.dao")

@RestController
public class MainController {

    public String result = "";

    @Autowired
    private SocialMapper socialMapper;

    @GetMapping("/test")
    public String test(){
        //socialMapper.test();
        return "social";
    }
}
