package com.huazaiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huazaiki.entity.Cinemas;
import com.huazaiki.mapper.CinemasMapper;
import com.huazaiki.service.CinemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【cinemas】的数据库操作Service实现
* @createDate 2024-08-29 19:41:19
*/
@Service
public class CinemasServiceImpl extends ServiceImpl<CinemasMapper, Cinemas>
    implements CinemasService{

    @Autowired
    private CinemasMapper cinemasMapper;

    @Override
    public void addCinemaInfo(Cinemas cinemas) {
        cinemasMapper.insert(cinemas);
    }

    @Override
    public void deleteCinemaById(Integer cinId) {
        cinemasMapper.deleteById(cinId);
    }

    @Override
    public void updateCinemaInfo(Cinemas cinemas) {
        cinemasMapper.updateById(cinemas);
    }

    @Override
    public List<Cinemas> listAllCinemas() {
        return cinemasMapper.selectList(null);
    }

    @Override
    public List<Cinemas> listCinemasByName(String cinemaName) {
        return cinemasMapper.selectCinemasByUsername(cinemaName);
    }
}




