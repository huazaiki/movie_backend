package com.huazaiki.controller;

import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Cinemas;
import com.huazaiki.service.CinemasService;
import com.huazaiki.service.SchedulesService;
import com.huazaiki.utils.Result;
import com.huazaiki.utils.ScheduleVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cinema")
@Tag(name = "影院操作接口", description = "影院API")
public class CinemasController {

    @Autowired
    private CinemasService cinemasService;

    @Autowired
    private SchedulesService schedulesService;

    /**
     * 添加影院信息
     * @param cinName 影院名称
     * @param cinAddress 影院地址
     * @param cinPhone 影院联系方式
     */
    @PostMapping("/add")
    @Operation(summary = "添加影院", description = "表中添加一所影院")
    public Result<Cinemas> addCinema(@RequestParam String cinName,
                                    @RequestParam String cinAddress,
                                    @RequestParam String cinPhone) {
        try {
            Cinemas cinemas = new Cinemas();
            cinemas.setCinName(cinName);
            cinemas.setCinAddress(cinAddress);
            cinemas.setCinPhone(cinPhone);
            cinemasService.addCinemaInfo(cinemas);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(503, "插入失败" + e.getMessage());
        }
    }


    /**
     * 删除影院信息
     * @param cinId 影院ID
     */
    @DeleteMapping("/delete/{cinId}")
    @Operation(summary = "删除影院", description = "表中删除一所影院")
    public Result<Cinemas> deleteCinema(@PathVariable Integer cinId) {
        try {
            cinemasService.deleteCinemaById(cinId);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(503, "删除失败" + e.getMessage());
        }
    }


    /**
     * 修改影院信息
     * @param cinId 影院ID
     * @param cinName 影院名称
     * @param cinAddress 影院地址
     * @param cinPhone 影院联系方式
     */
    @PostMapping("/update")
    @Operation(summary = "修改影院信息", description = "表中修改一所影院的信息")
    public Result<Cinemas> updateCinema(@RequestParam Integer cinId,
                                        @RequestParam String cinName,
                                        @RequestParam String cinAddress,
                                        @RequestParam String cinPhone) {
        try {
            Cinemas cinemas = new Cinemas();
            cinemas.setCinId(cinId);
            cinemas.setCinName(cinName);
            cinemas.setCinAddress(cinAddress);
            cinemas.setCinPhone(cinPhone);
            cinemasService.updateCinemaInfo(cinemas);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(503, "修改失败" + e.getMessage());
        }
    }

    /**
     * 查询影院所有信息
     */
    @GetMapping("/list")
    @Operation(summary = "查询所有影院", description = "表中查询所有影院")
    public Result<List<Cinemas>> listCinemas() {
        try {;
            return Result.success(cinemasService.listAllCinemas());
        } catch (Exception e) {
            return Result.failure(503, "查询失败" + e.getMessage());
        }
    }


    /**
     * 根据名称 模糊查找影院信息
     * @param cinName 影院名称（模糊）
     * @return
     */
    @GetMapping("/listCinemas/{cinName}")
    @Operation(summary = "模糊查询影院", description = "根据输入字段模糊查询一所影院")
    public Result<List<Cinemas>> listCinemaByName(@PathVariable String cinName) {
        try {;
            return Result.success(cinemasService.listCinemasByName(cinName));
        } catch (Exception e) {
            return Result.failure(503, "查询失败" + e.getMessage());
        }
    }

    /**
     * 联合查询影院排片信息
     */
    @GetMapping("/listMovies")
    @Operation(summary = "联合查询", description = "查询影院排片信息")
    public Result<List<ScheduleVo>> listMovies() {
        try {
            List<ScheduleVo> movies = schedulesService.getMovies();
            return Result.success(movies);
        } catch (Exception e) {
            return Result.failure(503, e.getMessage());
        }
    }

    @GetMapping("/listMoviesByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<ScheduleVo>> listMoviesByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        try {
            PageInfo<ScheduleVo> movies = schedulesService.getMoviesByPage(pageNum, pageSize);
            return Result.success(movies);
        } catch (Exception e) {
            return Result.failure(503, e.getMessage());
        }
    }
}
