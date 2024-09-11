package com.huazaiki.controller;

import com.huazaiki.entity.Users;
import com.huazaiki.service.UsersService;
import com.huazaiki.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Tag(name = "管理员用户接口")
public class AdminController {

    @Autowired
    private UsersService usersService;

    // 管理员登陆接口
    @PostMapping("/login")
    @Operation(summary = "管理员用户登陆")
    public Result login(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd) {
        try {
            Users users = usersService.userLogin(userName, userPwd);
            if (users == null) {
                return Result.forbidden("用户名或密码错误");
            } else if (users.getIsAdmin() != 1) {
                return Result.unauthorized("权限不足，非管理员用户");
            } else {
                return Result.success(users);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
