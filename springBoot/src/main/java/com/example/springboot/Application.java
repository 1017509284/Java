package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// !标注这是一个springboot的应用
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // !将springboot应用启动
        SpringApplication.run(Application.class, args);
    }

}
