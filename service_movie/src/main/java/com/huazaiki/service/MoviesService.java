package com.huazaiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Movies;
import com.huazaiki.entity.vo.ScheduleVO;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【movies】的数据库操作Service
* @createDate 2024-09-11 00:05:10
*/
public interface MoviesService extends IService<Movies> {

    /**
     * 添加电影信息
     * @param movie
     * @return
     */
    public Movies addMovie(Movies movie);

    /**
     * 更新电影信息
     * @param movie
     * @return
     */
    public Movies updateMovie(Movies movie);

    /**
     * 删除电影信息
     * @param id
     * @return
     */
    public Integer deleteMovie(Integer id);

    /**
     * 根据 电影ID 获取电影信息
     * @param movieId
     * @return
     */
    public Movies getMovie(Integer movieId);

    /**
     * 获取所有影片信息
     * @return
     */
    public List<Movies> getAllMovies();

    /**
     * 分页显示所有影片信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Movies> getMoviesByPage(Integer pageNum, Integer pageSize);

    /**
     * 联合查找影片放映信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<ScheduleVO> getMoviesOnShow(Integer pageNum, Integer pageSize);

    /**
     * 根据电影名称 模糊搜索 电影信息
     * @param title
     * @return
     */
    public List<Movies> getMoviesByTitle(String title);

    /**
     * 根据导演名称 模糊搜索 电影信息
     * @param director
     * @return
     */
    public List<Movies> getMoviesByDirector(String director);

    /**
     * 根据 评分 匹配电影信息
     * @param rating
     * @return
     */
    public List<Movies> getMovieByRating(Double rating);
}
