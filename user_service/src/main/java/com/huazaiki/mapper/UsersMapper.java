package com.huazaiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huazaiki.domain.Users;
import org.apache.ibatis.annotations.Mapper;

/**
* @author huazaiki
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-08-29 09:47:42
* @Entity com.huazaiki.domain.Users
*/
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    Users selectByUsername(String userName);
}




