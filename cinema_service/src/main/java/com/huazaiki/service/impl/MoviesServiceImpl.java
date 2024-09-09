package com.huazaiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huazaiki.entity.Movies;
import com.huazaiki.mapper.MoviesMapper;
import com.huazaiki.service.MoviesService;
import org.springframework.stereotype.Service;

/**
* @author huazaiki
* @description 针对表【movies】的数据库操作Service实现
* @createDate 2024-08-29 21:47:32
*/
@Service
public class MoviesServiceImpl extends ServiceImpl<MoviesMapper, Movies>
    implements MoviesService{

}




