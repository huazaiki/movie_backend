package com.huazaiki.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huazaiki.entity.Users;
import com.huazaiki.entity.vo.LoginDTO;
import com.huazaiki.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping(value = "/consumer")
@Tag(name = "消费者接口")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 普通用户登陆接口
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "普通用户登陆接口")
    public Result login(@RequestBody LoginDTO loginDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map request = objectMapper.convertValue(loginDTO, Map.class);
        return restTemplate.postForObject(
                "http://user-service/user/login", request, Result.class);
    }

    /**
     * 用户注册接口
     * @param users
     * @return
     */
    @PostMapping("/register")
    @Operation(summary = "用户注册接口")
    public Result register(@RequestBody Users users) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map request = objectMapper.convertValue(users, Map.class);
        return restTemplate.postForObject(
                "http://user-service/user/register", request, Result.class);
    }

    /**
     * 用户界面分页查询排片信息
     * @param pageNo
     * @param pageNum
     * @return
     */
    @GetMapping("/moviesOnShow/{pageNo}/{pageNum}")
    @Operation(summary = "用户界面分页查询排片信息")
    public Result getMoviesByPage(@PathVariable Integer pageNo, @PathVariable Integer pageNum) {
        return restTemplate.getForObject(
                "http://movie-cinema-service/movie/showing/{pageNo}/{pageNum}", Result.class, pageNo, pageNum);
    }

    /**
     * 查询所有影院信息
     * @return
     */
    @GetMapping("/info/allCinemas")
    @Operation(summary = "查询所有影院信息")
    public Result getCinemasInfo() {
        return restTemplate.getForObject(
                "http://movie-cinema-service/cinema/allInfos", Result.class);
    }

    /**
     * 根据影院名查询影院信息
     * @param name
     * @return
     */
    @GetMapping("/info/cinema/{cinemaName}")
    @Operation(summary = "根据影院名查询影院信息")
    public Result getCinemasInfoByName(@PathVariable("cinemaName") String name) {
        return restTemplate.getForObject(
                "http://movie-cinema-service/cinema/name/{name}", Result.class, name);
    }

    // 查询影院在映电影

    /**
     * 查询个人信息
     * @param userId
     * @return
     */
    @GetMapping("/info/user/{userId}")
    @Operation(summary = "查询个人信息")
    public Result getUsersInfo(@PathVariable Integer userId) {
        return restTemplate.getForObject(
                "http://user-service/user/id/{userId}", Result.class, userId);
    }
}
