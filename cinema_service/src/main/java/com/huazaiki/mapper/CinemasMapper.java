package com.huazaiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huazaiki.entity.Cinemas;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【cinemas】的数据库操作Mapper
* @createDate 2024-08-29 19:41:19
* @Entity com.huazaiki.domain.Cinemas
*/
@Mapper
public interface CinemasMapper extends BaseMapper<Cinemas> {

    List<Cinemas> selectCinemasByUsername(String userName);
}




