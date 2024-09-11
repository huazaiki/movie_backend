package com.huazaiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Movies;
import com.huazaiki.entity.vo.ScheduleVO;
import com.huazaiki.mapper.CinemasMapper;
import com.huazaiki.mapper.SchedulesMapper;
import com.huazaiki.service.MoviesService;
import com.huazaiki.mapper.MoviesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【movies】的数据库操作Service实现
* @createDate 2024-09-11 00:05:10
*/
@Service
public class MoviesServiceImpl extends ServiceImpl<MoviesMapper, Movies>
    implements MoviesService{

    @Autowired
    private MoviesMapper moviesMapper;

    @Autowired
    private SchedulesMapper schedulesMapper;

    @Autowired
    private CinemasMapper cinemasMapper;

    @Override
    public Movies addMovie(Movies movie) {
        // 'res' 为操作成功的事务数
        int res = moviesMapper.insert(movie);
        return res == 1 ? movie : null;
    }

    @Override
    public Movies updateMovie(Movies movie) {
        // 'res' 为操作成功的事务数
        int res = moviesMapper.updateById(movie);
        return res == 1 ? movie : null;
    }

    @Override
    public Integer deleteMovie(Integer id) {
        int res = moviesMapper.deleteById(id);
        return res == 1 ? res : null;
    }

    @Override
    public Movies getMovie(Integer movieId) {
        return moviesMapper.selectById(movieId);
    }

    @Override
    public List<Movies> getAllMovies() {
        return moviesMapper.selectList(null);
    }

    @Override
    public PageInfo<Movies> getMoviesByPage(Integer pageNo, Integer pageNum){
        PageHelper.startPage(pageNo, pageNum);
        List<Movies> movies = moviesMapper.selectList(null);
        return new PageInfo<>(movies);
    }

    @Override
    public PageInfo<ScheduleVO> getMoviesOnShow(Integer pageNo, Integer pageNum) {
        PageHelper.startPage(pageNo, pageNum);
        return new PageInfo<>(schedulesMapper.selectRef());
    }

    @Override
    public List<Movies> getMoviesByTitle(String title) {
        return moviesMapper.selectList(new QueryWrapper<Movies>().like("mov_title", title));
    }

    @Override
    public List<Movies> getMoviesByDirector(String director) {
        return moviesMapper.selectList(new QueryWrapper<Movies>().like("mov_director", director));
    }

    @Override
    public List<Movies>  getMovieByRating(Double rating) {
        return moviesMapper.selectList(new QueryWrapper<Movies>().eq("mov_rating", rating));
    }
}




