package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhaomeng
 * @Date: 2022/12/11 23:15
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World";
    }
}
