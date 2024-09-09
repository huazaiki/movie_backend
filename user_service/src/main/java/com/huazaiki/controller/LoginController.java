package com.huazaiki.controller;

import com.huazaiki.entity.Users;
import com.huazaiki.service.UsersService;
import com.huazaiki.utils.LoginVo;
import com.huazaiki.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user", method = {RequestMethod.GET, RequestMethod.POST})
public class LoginController {

    @Autowired
    private UsersService usersService;

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

    @PostMapping("/adminLogin")
    public Result adminLogin(@RequestBody LoginVo loginVo) {
        Users userRes = usersService.adminLogin(loginVo.getUserName(), loginVo.getUserPwd());
        try {
            if (userRes == null) {
                return Result.failure(401, "认证失败");
            }
            return Result.success(userRes);
        } catch (Exception e) {
            return Result.failure(503, e.getMessage());
        }
    }

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
