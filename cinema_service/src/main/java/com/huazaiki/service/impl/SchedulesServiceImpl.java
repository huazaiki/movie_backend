package com.huazaiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazaiki.domain.Schedules;
import com.huazaiki.mapper.SchedulesMapper;
import com.huazaiki.service.SchedulesService;
import com.huazaiki.utils.ScheduleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【schedules】的数据库操作Service实现
* @createDate 2024-08-29 19:43:25
*/
@Service
public class SchedulesServiceImpl extends ServiceImpl<SchedulesMapper, Schedules>
    implements SchedulesService{

    @Autowired
    private SchedulesMapper schedulesMapper;

    @Override
    public List<ScheduleVo> getMovies() {
        return schedulesMapper.selectRef();
    }

    @Override
    public PageInfo<ScheduleVo> getMoviesByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(schedulesMapper.selectRef());
    }
}




