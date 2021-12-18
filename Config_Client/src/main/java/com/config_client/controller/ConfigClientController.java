package com.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${config}")
    private String config;

    @GetMapping("/home")
    public String home() {
        return "return" + config;
    }
}
