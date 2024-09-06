package com.huazaiki.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huazaiki.domain.Users;
import com.huazaiki.utils.Result;
import com.huazaiki.vo.LoginVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/consumer", method = {RequestMethod.POST, RequestMethod.GET})
@Tag(name = "消费者接口", description = "消费者API")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map request = objectMapper.convertValue(loginVo, Map.class);
        return restTemplate.postForObject("http://user-service/api/v1/user/login", request, Result.class);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Users users) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map request = objectMapper.convertValue(users, Map.class);
        return restTemplate.postForObject("http://user-service/api/v1/user/register", request, Result.class);
    }

    // 查询排片信息
    @GetMapping("/info/moviesOnShow")
    public Result getMovies() {
        return restTemplate.getForObject("http://cinema-service/api/v1/cinema/listMovies", Result.class);
    }


    @GetMapping("/info/listMoviesByPage/{pageNum}/{pageSize}")
    public Result getMoviesByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return restTemplate.getForObject("http://cinema-service/api/v1/cinema/listMoviesByPage/{pageNum}/{pageSize}", Result.class, pageNum, pageSize);
    }

    // 查询所有影院信息
    @GetMapping("/info/cinema")
    public Result getCinemasInfo() {
        return restTemplate.getForObject("http://cinema-service/api/v1/cinema/list", Result.class);
    }

    // 查询所有影院信息
    @GetMapping("/info/cinema/{cinemaName}")
    public Result getCinemasInfoByName(@PathVariable String cinemaName) {
        return restTemplate.getForObject(
                "http://cinema-service/api/v1/cinema/listCinemas/{cinemaName}", Result.class, cinemaName);
    }

    // 查询个人信息
    @GetMapping("/info/user/{userId}")
    public Result getUsersInfo(@PathVariable Integer userId) {
        return restTemplate.getForObject("http://user-service/api/v1/user/listUser/id/{userId}", Result.class, userId);
    }

    // 分页查询
    @GetMapping("/info/page/{pageNum}/{pageSize}")
    public Result getPageInfo(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return restTemplate.getForObject(
                "http://user-service/api/v1/user/listUser/page/{pageNum}/{pageSize}",
                Result.class, pageNum, pageSize);
    }
}
