package com.huazaiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazaiki.domain.Users;
import com.huazaiki.mapper.UsersMapper;
import com.huazaiki.service.UsersService;
import com.huazaiki.utils.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-08-29 09:47:42
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> findAll() {
        return usersMapper.selectList(null);
    }

    @Override
    public Integer insertUser(Users users) {
        users.setIsAdmin(0);
        return usersMapper.insert(users);
    }

    @Override
    public Integer updateUser(Users users) {
        return usersMapper.updateById(users);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return usersMapper.deleteById(id);
    }

    @Override
    public Users findUserById(Integer id) {
        return usersMapper.selectById(id);
    }

    @Override
    public List<Users> findUserByUsername(String username) {
        return usersMapper.selectList(new QueryWrapper<Users>().like("username", username));
    }

    @Override
    public PageInfo<Users> findUserByPage(Integer pageNum, Integer pageSize, UsersVo usersVo) {
        PageHelper.startPage(pageNum, pageSize);
        List<Users> usersList = usersMapper.selectList(null);
        PageInfo<Users> pageInfo = new PageInfo<>(usersList);
        return pageInfo;
    }

    @Override
    public Users userLogin(String username, String password) {
        // 匹配用户名和密码
        QueryWrapper<Users> query = new QueryWrapper<>();
        query.eq("user_name", username);
        query.eq("user_pwd", password);

        Users user = usersMapper.selectOne(query);
        return user;
    }

    @Override
    public Users userRegister(Users users) {
        Integer i = insertUser(users);
        return i == 1 ? users : null;
    }
}




