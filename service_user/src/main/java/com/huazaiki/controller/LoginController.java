package com.huazaiki.controller;

import com.huazaiki.entity.Users;
import com.huazaiki.service.UsersService;
import com.huazaiki.entity.vo.LoginVo;
import com.huazaiki.utils.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "用户登陆和注册相关API")
public class LoginController {

    @Autowired
    private UsersService usersService;

    /**
     * 用户登陆接口
     * @param loginVo
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        Users userRes = usersService.userLogin(loginVo.getUserName(), loginVo.getUserPwd());
        try {
            if (userRes == null) {
                return Result.failure(401, "认证失败");
            }
            return Result.success(userRes);
        } catch (Exception e) {
            return Result.failure(503, e.getMessage());
        }
    }

    /**
     * 用户注册接口
     * @param users
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Users users) {
        Users userRes = usersService.userRegister(users);
        try {
            if (userRes == null) {
                return Result.failure(400, "注册失败");
            }
            return Result.success(userRes);
        } catch (Exception e) {
            return Result.failure(503, e.getMessage());
        }
    }
}
