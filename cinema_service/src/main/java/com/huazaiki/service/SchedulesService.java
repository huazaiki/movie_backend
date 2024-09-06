package com.huazaiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.huazaiki.domain.Schedules;
import com.huazaiki.utils.ScheduleVo;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【schedules】的数据库操作Service
* @createDate 2024-08-29 19:43:25
*/
public interface SchedulesService extends IService<Schedules> {
    List<ScheduleVo> getMovies();
    PageInfo<ScheduleVo> getMoviesByPage(Integer pageNum, Integer pageSize);
}
