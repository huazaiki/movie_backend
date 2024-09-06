package com.huazaiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huazaiki.domain.Schedules;
import com.huazaiki.utils.ScheduleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【schedules】的数据库操作Mapper
* @createDate 2024-08-29 19:43:25
* @Entity com.huazaiki.domain.Schedules
*/
@Mapper
public interface SchedulesMapper extends BaseMapper<Schedules> {
    public List<ScheduleVo> selectRef();
}