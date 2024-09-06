package com.huazaiki.controller;

import com.huazaiki.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

//@RestController
//@RequestMapping("/api/v1/admin")
//@Tag(name = "管理员消费者接口", description = "管理员消费者API")
public class AdminConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // 删除用户信息
    @PostMapping("/delUser")
    public Result delUser(@RequestParam Integer userId) {
        return restTemplate.postForObject(
                "http://user-service/api/v1/user/delete/{userId}", userId, Result.class);
    }

    // 修改用户信息
//    @PostMapping("/udtUser")
//    public Result udtUser(@RequestBody User user) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map request = objectMapper.convertValue(user, Map.class);
//
//        return restTemplate.postForObject(
//                "http://user-service/api/v1/user/update/{userId}", request, Result.class);
//    }

    // 增加用户信息

    // 修改影片信息
}
