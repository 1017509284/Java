package com.zhaomeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: zhaomeng
 * @Date: 2022/11/25 17:11
 */

@SpringBootApplication
public class BilibiliApp {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(BilibiliApp.class, args);
    }
}
