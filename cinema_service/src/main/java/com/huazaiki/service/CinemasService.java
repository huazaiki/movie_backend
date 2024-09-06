package com.huazaiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazaiki.domain.Cinemas;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【cinemas】的数据库操作Service
* @createDate 2024-08-29 19:41:19
*/
public interface CinemasService extends IService<Cinemas> {

    void addCinemaInfo(Cinemas cinemas);

    void deleteCinemaById(Integer cinId);

    void updateCinemaInfo(Cinemas cinemas);

    List<Cinemas> listAllCinemas();

    List<Cinemas> listCinemasByName(String cinemaName);
}
