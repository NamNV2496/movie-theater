package com.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${str}")
    private String config;

    @GetMapping("/home")
    public String home() {
        System.out.println(config);
        return "string";
//        return "return" + my;
    }
}
