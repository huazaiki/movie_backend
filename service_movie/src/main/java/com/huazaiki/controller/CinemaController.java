package com.huazaiki.controller;

import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Cinemas;
import com.huazaiki.entity.Movies;
import com.huazaiki.entity.vo.ScheduleVO;
import com.huazaiki.service.CinemasService;
import com.huazaiki.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@Tag(name = "影院相关API")
public class CinemaController {

    @Autowired
    private CinemasService cinemasService;

    /**
     * 新增影院信息
     * @param cinemas
     * @return
     */
    @PostMapping("/add")
    @Operation(summary = "新增影院")
    public Result<Cinemas> addCinema(@RequestBody Cinemas cinemas){
        try {
            Cinemas newCinema = cinemasService.addCinemas(cinemas);
            if (newCinema != null) {
                return Result.success(newCinema);
            } else {
                return Result.forbidden("增加失败，请联系管理员");
            }
        } catch (Exception e) {
            return Result.failure(500, "新增影院时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 删除影片信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除影院")
    public Result deleteCinema(@PathVariable Integer id){
        try {
            Integer delNum = cinemasService.deleteCinemas(id);
            if (delNum > 0) {
                return Result.success(); // 删除成功
            } else if (cinemasService.getCinemasById(id) == null) {
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
     * 更新影院信息
     * @param cinemas
     * @return
     */
    @PostMapping("/update")
    @Operation(summary = "更新影院信息")
    public Result<Movies> updateCinema(@RequestBody Cinemas cinemas) {

        // 检查电影是否存在
        if (cinemas.getCinId() == null || cinemasService.getCinemasById(cinemas.getCinId()) == null) {
            // 返回 404：电影不存在
            return Result.failure(404, "未找到要更新的影院");
        }

        // 执行更新操作
        try {
            Cinemas updatedCinemas = cinemasService.updateCinemas(cinemas);
            if (updatedCinemas != null) {
                // 返回 200：更新成功
                return Result.success();
            } else {
                // 返回 500：更新失败，服务器错误
                return Result.failure(500, "更新影院时发生服务器错误");
            }
        } catch (Exception e) {
            // 返回 500：处理未知异常
            return Result.failure(500, "更新影院时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 根据影院ID获取影院信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "获取影院信息")
    public Result<Cinemas> getCinema(@PathVariable Integer id){

        // 检查电影是否存在
        Cinemas cinemas = cinemasService.getCinemasById(id);
        if (cinemas == null) {
            // 返回 404：电影不存在
            return Result.failure(404, "未找到要查找的影院");
        }

        try {
            return Result.success(cinemas);
        } catch (Exception e) {
            return Result.failure(500, "获取影院信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 获取所有影院信息
     * @return
     */
    @GetMapping("/allInfos")
    @Operation(summary = "分页获取所有影院信息")
    public Result<List<Cinemas>> getAllCinemas(){
        List<Cinemas> cinemas= cinemasService.getAllCinemas();

        try {
            return Result.success(cinemas);
        } catch (Exception e) {
            return Result.failure(500, "分页查询所有影院信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 分页获取所有影院信息
     * @param pageNo
     * @param pageNum
     * @return
     */
    @GetMapping("/page/{pageNo}/{pageNum}")
    @Operation(summary = "分页获取所有影院信息")
    public Result<PageInfo<Cinemas>> getCinemasPage(@PathVariable Integer pageNo, @PathVariable Integer pageNum){
        PageInfo<Cinemas> cinemasByPage = cinemasService.getCinemasByPage(pageNo, pageNum);

        try {
            return Result.success(cinemasByPage);
        } catch (Exception e) {
            return Result.failure(500, "分页查询所有影院信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 根据影院名字获取影院信息
     * @param name
     * @return
     */
    @GetMapping("/name/{name}")
    @Operation(summary = "根据影院名字获取影院信息")
    public Result<List<Cinemas>> getCinemasByName(@PathVariable String name){

        List<Cinemas> cinemas = cinemasService.getCinemasByName(name);

        try {
            if (!cinemas.isEmpty()) {
                return Result.success(cinemas);
            } else {
                return Result.failure(404, "未找到要查找的影院");
            }
        } catch (Exception e) {
            return Result.failure(500, "分页查询所有影院信息时发生未知错误: " + e.getMessage());
        }
    }

    /**
     * 根据影院地址获取影院信息
     * @param address
     * @return
     */
    @GetMapping("/address/{address}")
    @Operation(summary = "根据影院地址获取影院信息")
    public Result<List<Cinemas>> getCinemasByAddress(@PathVariable String address){

        List<Cinemas> cinemas = cinemasService.getCinemasByAddress(address);

        try {
            if (!cinemas.isEmpty()) {
                return Result.success(cinemas);
            } else {
                return Result.failure(404, "未找到要查找的影院");
            }
        } catch (Exception e) {
            return Result.failure(500, "分页查询所有影院信息时发生未知错误: " + e.getMessage());
        }
    }
}
