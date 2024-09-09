package com.huazaiki.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huazaiki.entity.vo.LoginVo;
import com.huazaiki.utils.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/consumer/admin")
@Tag(name = "管理员消费者接口", description = "管理员消费者API")
public class AdminConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // 后台登录
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map request = objectMapper.convertValue(loginVo, Map.class);
        return restTemplate.postForObject("http://user-service/api/v1/user/adminLogin", request, Result.class);
    }

    // 删除用户信息
    @PostMapping("/delUser")
    public Result delUser(@RequestParam Integer userId) {
        return restTemplate.postForObject(
                "http://user-service/api/v1/user/delete/{userId}", userId, Result.class);
    }

    // 修改用户信息


    // 增加用户信息

    // 修改影片信息
}
