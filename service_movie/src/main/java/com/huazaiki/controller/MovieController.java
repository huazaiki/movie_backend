package com.huazaiki.controller;

import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Movies;
import com.huazaiki.entity.vo.ScheduleVO;
import com.huazaiki.service.MoviesService;
import com.huazaiki.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@Tag(name = "影片相关API")
public class MovieController {

    @Autowired
    private MoviesService moviesService;

    /**
     * 新增影片信息
     * @param movie
     * @return
     */
    @PostMapping("/add")
    @Operation(summary = "新增影片")
    public Result addMovie(@RequestBody Movies movie){
        try {
            Movies newMovie = moviesService.addMovie(movie);
            if (newMovie != null) {
                return Result.success();
            } else {
                return Result.forbidden("增加失败，请联系管理员");
            }
        } catch (Exception e) {
            return Result.failure(500, "新增电影时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 删除影片信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除影片")
    public Result deleteMovie(@PathVariable Integer id){
        try {
            Integer delNum = moviesService.deleteMovie(id);
            if (delNum > 0) {
                return Result.success(); // 删除成功
            } else if (moviesService.getMovie(id) == null) {
                // 返回 404：电影不存在
                return Result.failure(404, "未找到要删除的电影");
            } else {
                // 返回 500：服务器错误
                return Result.failure(500, "删除电影时发生服务器错误");
            }
        } catch (Exception e) {
            return Result.failure(500, "删除电影时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 更新影片信息
     * @param movies
     * @return
     */
    @PostMapping("/update")
    @Operation(summary = "更新影片信息")
    public Result<Movies> updateMovie(@RequestBody Movies movies){

        // 检查电影是否存在
        if (movies.getMovId() == null || moviesService.getMovie(movies.getMovId()) == null) {
            // 返回 404：电影不存在
            return Result.failure(404, "未找到要更新的电影");
        }

        // 执行更新操作
        try {
            Movies updatedMovie = moviesService.updateMovie(movies);
            if (updatedMovie != null) {
                // 返回 200：更新成功
                return Result.success();
            } else {
                // 返回 500：更新失败，服务器错误
                return Result.failure(500, "更新电影时发生服务器错误");
            }
        } catch (Exception e) {
            // 返回 500：处理未知异常
            return Result.failure(500, "更新电影时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 根据影片ID获取影片信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "获取影片信息")
    public Result<Movies> getMovie(@PathVariable Integer id){

        // 检查电影是否存在
        Movies movie = moviesService.getMovie(id);
        if (movie == null) {
            // 返回 404：电影不存在
            return Result.failure(404, "未找到要查找的电影");
        }

        try {
            return Result.success(movie);
        } catch (Exception e) {
            return Result.failure(500, "获取电影信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 分页获取所有影片信息
     * @param pageNo
     * @param pageNum
     * @return
     */
    @GetMapping("/page/{pageNo}/{pageNum}")
    @Operation(summary = "分页获取所有影片信息")
    public Result<PageInfo<Movies>> getMoviesPage(@PathVariable Integer pageNo, @PathVariable Integer pageNum){
        PageInfo<Movies> moviesByPage = moviesService.getMoviesByPage(pageNo, pageNum);

        try {
            return Result.success(moviesByPage);
        } catch (Exception e) {
            return Result.failure(500, "分页查询所有影片信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 根据电影标题获取影片信息
     * @param title
     * @return
     */
    @GetMapping("/title/{title}")
    @Operation(summary = "根据电影标题获取影片信息")
    public Result<List<Movies>> getMoviesByTitle(@PathVariable String title){

        List<Movies> movies = moviesService.getMoviesByTitle(title);

        try {
            if (!movies.isEmpty()) {
                return Result.success(movies);
            } else {
                return Result.failure(404, "未找到要查找的电影");
            }
        } catch (Exception e) {
            return Result.failure(500, "分页查询所有影片信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 根据电影导演获取影片信息
     * @param director
     * @return
     */
    @GetMapping("/director/{director}")
    @Operation(summary = "根据电影导演获取影片信息")
    public Result<List<Movies>> getMoviesByDirector(@PathVariable String director){

        List<Movies> movies = moviesService.getMoviesByDirector(director);

        try {
            if (!movies.isEmpty()) {
                return Result.success(movies);
            } else {
                return Result.failure(404, "未找到要查找的电影");
            }
        } catch (Exception e) {
            return Result.failure(500, "分页查询所有影片信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 根据电影评分获取影片信息
     * @param rating
     * @return
     */
    @GetMapping("/rate/{rating}")
    @Operation(summary = "根据电影评分获取影片信息")
    public Result<List<Movies>> getMovieByRating(@PathVariable Double rating){

        List<Movies> movies = moviesService.getMovieByRating(rating);

        try {
            if (!movies.isEmpty()) {
                return Result.success(movies);
            } else {
                return Result.failure(404, "未找到要查找的电影");
            }
        } catch (Exception e) {
            return Result.failure(500, "分页查询所有影片信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 影片联查，查询正在上映的影片
     * @param pageNo
     * @param pageNum
     * @return
     */
    @GetMapping("/showing/{pageNo}/{pageNum}")
    @Operation(summary = "在映影片联查")
    public Result<PageInfo<ScheduleVO>> getShowingMovies(@PathVariable Integer pageNo, @PathVariable Integer pageNum){

        PageInfo<ScheduleVO> moviesOnShow = moviesService.getMoviesOnShow(pageNo, pageNum);

        try {
            return Result.success(moviesOnShow);
        } catch (Exception e) {
            return Result.failure(500, "在映影片联查时发生未知错误: " + e.getMessage());
        }
    }
}
