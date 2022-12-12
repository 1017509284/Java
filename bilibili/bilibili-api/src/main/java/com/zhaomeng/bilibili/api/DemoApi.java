package com.zhaomeng.bilibili.api;

import com.zhaomeng.bilibili.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhaomeng
 * @Date: 2022/11/26 00:51
 */

@RestController
public class DemoApi {

    @Autowired
    private DemoService demoService;

    @GetMapping("/query")
    public Long query(Long id) {
        return demoService.query(id);
    }
}
