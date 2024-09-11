package com.huazaiki.mapper;

import com.huazaiki.entity.Movies;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author huazaiki
* @description 针对表【movies】的数据库操作Mapper
* @createDate 2024-09-11 00:05:10
* @Entity com.huazaiki.domain.Movies
*/
@Mapper
public interface MoviesMapper extends BaseMapper<Movies> {

}




