package com.huazaiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huazaiki.domain.Movies;
import org.apache.ibatis.annotations.Mapper;

/**
* @author huazaiki
* @description 针对表【movies】的数据库操作Mapper
* @createDate 2024-08-29 21:47:32
* @Entity com.huazaiki.domain.Movies
*/
@Mapper
public interface MoviesMapper extends BaseMapper<Movies> {

}




