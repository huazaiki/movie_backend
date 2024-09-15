package com.huazaiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huazaiki.entity.Schedules;
import com.huazaiki.entity.vo.ScheduleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【schedules】的数据库操作Mapper
* @createDate 2024-09-11 00:05:10
* @Entity com.huazaiki.domain.Schedules
*/
@Mapper
public interface SchedulesMapper extends BaseMapper<Schedules> {

    /**
     * 联合查询数据库排片信息
     * @return
     */
    public List<ScheduleVO> selectRef();
}




