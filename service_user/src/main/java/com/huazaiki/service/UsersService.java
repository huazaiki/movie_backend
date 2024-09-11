package com.huazaiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Users;
import com.huazaiki.entity.vo.SearchVO;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【users】的数据库操作Service
* @createDate 2024-08-29 09:47:42
*/
public interface UsersService extends IService<Users> {

    /**
     * 查询所有用户
     * @return List<Users>
     */
    List<Users> findAll();

    /**
     * 根据用户ID创建用户
     * @param users
     * @return
     */
    Integer insertUser(Users users);

    /**
     * 根据用户ID更新用户
     * @param users
     * @return
     */
    Integer updateUser(Users users);

    /**
     * 根据用户ID删除用户
     * @param id
     * @return
     */
    Integer deleteUser(Integer id);

    /**
     * 根据用户ID查询用户
     * @param id
     * @return
     */
    Users findUserById(Integer id);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    List<Users> findUserLikeUsername(String username);

    /**
     * 分页查询用户
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo<Users> findUserByPage(Integer pageNum, Integer pageSize, SearchVO searchVO);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Users userLogin(String username, String password);

    /**
     * 用户注册
     * @param users
     * @return
     */
    Users userRegister(Users users);

}
