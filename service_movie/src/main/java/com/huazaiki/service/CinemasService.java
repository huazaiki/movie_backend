package com.huazaiki.service;

import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Cinemas;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【cinemas】的数据库操作Service
* @createDate 2024-09-11 00:05:11
*/
public interface CinemasService extends IService<Cinemas> {

    /**
     * 添加影院信息
     * @param cinemas
     * @return
     */
    public Cinemas addCinemas(Cinemas cinemas);

    /**
     * 更新影院信息
     * @param id
     * @return
     */
    public Integer deleteCinemas(Integer id);

    /**
     * 更新影院信息
     * @param cinemas
     * @return
     */
    public Cinemas updateCinemas(Cinemas cinemas);

    /**
     * 根据 影院ID 获取影院信息
     * @param id
     * @return
     */
    public Cinemas getCinemasById(Integer id);

    /**
     * 获取所有影院信息
     * @return
     */
    public List<Cinemas> getAllCinemas();

    /**
     * 分页查询影院信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Cinemas> getCinemasByPage(Integer pageNum, Integer pageSize);

    /**
     * 根据 影院名称 模糊查找影院信息
     * @param name
     * @return
     */
    public List<Cinemas> getCinemasByName(String name);

    /**
     * 根据 影院地址 模糊查找影院信息
     * @param address
     * @return
     */
    public List<Cinemas> getCinemasByAddress(String address);
}
