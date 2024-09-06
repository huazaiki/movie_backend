package com.huazaiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.huazaiki.domain.Users;
import com.huazaiki.utils.UsersVo;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【users】的数据库操作Service
* @createDate 2024-08-29 09:47:42
*/
public interface UsersService extends IService<Users> {

    List<Users> findAll();
    Integer insertUser(Users users);
    Integer updateUser(Users users);
    Integer deleteUser(Integer id);

    Users findUserById(Integer id);
    List<Users> findUserByUsername(String username);

    PageInfo<Users> findUserByPage(Integer pageNum, Integer pageSize, UsersVo usersVo);

    Users userLogin(String username, String password);
    Users userRegister(Users users);
}
