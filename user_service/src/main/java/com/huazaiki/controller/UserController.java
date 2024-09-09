package com.huazaiki.controller;

import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Users;
import com.huazaiki.service.UsersService;
import com.huazaiki.utils.Result;
import com.huazaiki.utils.UsersVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "用户操作接口", description = "用户API")
public class UserController {

    @Autowired
    private UsersService usersService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("Hello, eureka! from User(" + port + ")");
    }

    @GetMapping("/list")
    @Operation(summary = "查询所有用户", description = "列出所有用户")
    public Result<List<Users>> listAllUser() {
        try {
            return Result.success(usersService.list());
        } catch (Exception e) {
            return Result.failure(503, e.getMessage());
        }
    }

    // 增加
    @PostMapping("/save")
    @Operation(summary = "添加用户", description = "添加新用户")
    public Result<Users> saveUser(@RequestParam String userName,
                                 @RequestParam String userPwd,
                                 @RequestParam String userEmail,
                                 @RequestParam String userPhone) {
        Users users = new Users();
        users.setUserName(userName);
        users.setUserPwd(userPwd);
        users.setUserEmail(userEmail);
        users.setUserPhone(userPhone);
        try {
            Integer op = usersService.insertUser(users);
            return Result.success(users);
        } catch (Exception e) {
            return Result.failure(503, "添加失败 " + e.getMessage());
        }
    }

    // 删除
    @DeleteMapping("/delete/{userId}")
    @Operation(summary = "删除用户", description = "根据 userId 删除用户")
    public Result<String> deleteUser(@PathVariable Integer userId) {
        try {
            Integer op = usersService.deleteUser(userId);
            return Result.success("成功删除 " + op + " 条信息");
        } catch (Exception e) {
            return Result.failure(503, "删除失败 " + e.getMessage());
        }
    }

    // 修改
    @PostMapping("/update/{userId}")
    @Operation(summary = "更新信息", description = "根据 userId 更新用户信息")
    public Result<Users> updateUser(@PathVariable Integer userId,
                                    @RequestParam String userName,
                                    @RequestParam String userPwd,
                                    @RequestParam String userEmail,
                                    @RequestParam String userPhone) {
        Users users = new Users();
        users.setUserId(userId);
        users.setUserName(userName);
        users.setUserPwd(userPwd);
        users.setUserEmail(userEmail);
        users.setUserPhone(userPhone);
        try {
            Integer op = usersService.updateUser(users);
            return Result.success(users);
        } catch (Exception e) {
            return Result.failure(503, "更新成功 " + e.getMessage());
        }
    }


    @GetMapping("/listUser/id/{userId}")
    @Operation(summary = "查询指定用户", description = "根据 userId 查询用户")
    public Result<Users> listUserById(@PathVariable Integer userId) {
        try {
            Users users = usersService.findUserById(userId);
            return Result.success(users);
        } catch (Exception e) {
            return Result.failure(503, "查询失败 " + e.getMessage());
        }
    }

    @GetMapping("/listUser/name/{userName}")
    @Operation(summary = "模糊查找用户", description = "根据指定信息模糊查询")
    public Result<List<Users>> listUserByName(@PathVariable String userName) {
        try {
            List<Users> users = usersService.findUserByUsername(userName);
            return users.isEmpty() ? Result.failure(405, "查询失败，没有结果") : Result.success(users);
        } catch (Exception e) {
            return Result.failure(503, "查询失败 " + e.getMessage());
        }
    }

    @GetMapping("/listUser/page/{pageNum}/{pageSize}")
    @Operation(summary = "分页查询用户", description = "根据页码和每页显示数量显示用户")
    public Result<PageInfo<Users>> listUserByPage(@PathVariable Integer pageNum,
                                                  @PathVariable Integer pageSize,
                                                  @RequestBody @RequestParam(required = false) UsersVo usersVo) {
        try {
            PageInfo<Users> usersPageInfo = usersService.findUserByPage(pageNum, pageSize, null);
            return Result.success(usersPageInfo);
        } catch (Exception e) {
            return Result.failure(503, "无数据 " + e.getMessage());
        }
    }
}
