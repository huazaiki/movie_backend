package com.huazaiki.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huazaiki.entity.Cinemas;
import com.huazaiki.entity.Movies;
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
@RequestMapping("/consumer/admin")
@Tag(name = "管理员消费者接口", description = "管理员消费者API")
public class AdminConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 后台登录
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "后台登录")
    public Result login(@RequestBody LoginDTO loginDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map request = objectMapper.convertValue(loginDTO, Map.class);
        return restTemplate.postForObject(
                "http://user-service/admin/login", request, Result.class);
    }

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    @DeleteMapping("/delUser/{userId}")
    @Operation(summary = "删除用户信息")
    public Result delUser(@PathVariable Integer userId) {
        return restTemplate.postForObject(
                "http://user-service/user/delete/{userId}", userId, Result.class);
    }

    // 修改用户信息
    @PostMapping("/updateUser")
    @Operation(summary = "修改用户信息")
    public Result updateUser(@RequestBody Users users) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map request = objectMapper.convertValue(users, Map.class);
        return restTemplate.postForObject(
                "http://user-service/user/update", request, Result.class);
    }

    // 增加用户信息
    @PostMapping("/addUser")
    @Operation(summary = "增加用户信息")
    public Result addUser(@RequestBody Users users) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map request = objectMapper.convertValue(users, Map.class);
        return restTemplate.postForObject(
                "http://user-service/user/register", request, Result.class);
    }

    // 分页查询用户信息
    @GetMapping("/getUsers/{pageNo}/{pageNum}")
    @Operation(summary = "查询所有用户信息")
    public Result getUsers(@PathVariable Integer pageNo, @PathVariable Integer pageNum) {
        return restTemplate.getForObject(
                "http://user-service/user/pageList/{pageNo}/{pageNum}", Result.class, pageNo, pageNum);
    }

    // 根据用户名查询用户
    @GetMapping("/getUser/name/{name}")
    @Operation(summary = "根据用户名查询用户")
    public Result getUserByName(@PathVariable String name) {
        return restTemplate.getForObject(
                "http://movie-cinema-service/user/list/name/{name}", Result.class, name);
    }

    // 影院信息的增删改查
    @PostMapping("/addCinema")
    @Operation(summary = "新增影院信息")
    public Result addCinema(@RequestBody Cinemas cinemas) {
        Map request = new ObjectMapper().convertValue(cinemas, Map.class);
        return restTemplate.postForObject(
                "http://movie-cinema-service/cinema/add", request, Result.class);
    }

    @DeleteMapping("/delCinema/{id}")
    @Operation(summary = "删除影院信息")
    public Result delCinema(@PathVariable Integer id) {
        Map request = new ObjectMapper().convertValue(id, Map.class);
        return restTemplate.postForObject(
                "http://movie-cinema-service/cinema/delete/{id}", request, Result.class);
    }

    @PostMapping("/updateCinema")
    @Operation(summary = "更新影院信息")
    public Result updateCinema(@RequestBody Cinemas cinemas) {
        Map request = new ObjectMapper().convertValue(cinemas, Map.class);
        return restTemplate.postForObject(
                "http://movie-cinema-service/cinema/update", request, Result.class);
    }

    @GetMapping("/getCinemas/{pageNo}/{pageNum}")
    @Operation(summary = "分页获取用户信息")
    public Result getCinemas(@PathVariable Integer pageNo, @PathVariable Integer pageNum) {
        return restTemplate.getForObject(
                "http://movie-cinema-service/cinema/page/{pageNo}/{pageNum}", Result.class, pageNo, pageNum);
    }

    // 影片信息的增删改查
    @PostMapping("/addMovie")
    @Operation(summary = "新增影片信息")
    public Result addMovie(@RequestBody Movies movies) {
        Map request = new ObjectMapper().convertValue(movies, Map.class);
        return restTemplate.postForObject(
                "http://movie-cinema-service/movie/add", request, Result.class);
    }

    @DeleteMapping("/delMovie/{id}")
    @Operation(summary = "删除影片信息")
    public Result delMovie(@PathVariable Integer id) {
        Map request = new ObjectMapper().convertValue(id, Map.class);
        return restTemplate.postForObject(
                "http://movie-cinema-service/movie/delete/{id}", request, Result.class);
    }

    @PostMapping("/updateMovie")
    @Operation(summary = "更新影片信息")
    public Result updateMovie(@RequestBody Movies movies) {
        Map request = new ObjectMapper().convertValue(movies, Map.class);
        return restTemplate.postForObject(
                "http://movie-cinema-service/movie/update", request, Result.class);
    }

    @GetMapping("/getMovies/{pageNo}/{pageNum}")
    @Operation(summary = "分页查询影片信息")
    public Result getMovies(@PathVariable Integer pageNo, @PathVariable Integer pageNum) {
        return restTemplate.getForObject(
                "http://movie-cinema-service/movie/page/{pageNo}/{pageNum}", Result.class, pageNo, pageNum);
    }
}
