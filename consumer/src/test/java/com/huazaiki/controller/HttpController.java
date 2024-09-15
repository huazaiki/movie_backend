package com.huazaiki.controller;

import com.huazaiki.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HttpController {

    /**
     * 测试接口
     * @return
     */
    @GetMapping("/user")
    public Result getUser() {
        return Result.success();
    }
}