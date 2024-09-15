package com.huazaiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazaiki.entity.Cinemas;
import com.huazaiki.mapper.CinemasMapper;
import com.huazaiki.service.CinemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author huazaiki
* @description 针对表【cinemas】的数据库操作Service实现
* @createDate 2024-09-11 00:05:10
*/
@Service
public class CinemasServiceImpl extends ServiceImpl<CinemasMapper, Cinemas>
    implements CinemasService{

    @Autowired
    private CinemasMapper cinemasMapper;

    @Override
    public Cinemas addCinemas(Cinemas cinemas) {
        int res = cinemasMapper.insert(cinemas);
        return res == 1 ? cinemas : null;
    }

    @Override
    public Integer deleteCinemas(Integer id) {
        int res = cinemasMapper.deleteById(id);
        return res == 1 ? res : null;
    }

    @Override
    public Cinemas updateCinemas(Cinemas cinemas) {
        int res = cinemasMapper.updateById(cinemas);
        return res == 1 ? cinemas : null;
    }

    @Override
    public Cinemas getCinemasById(Integer id) {
        return cinemasMapper.selectById(id);
    }

    @Override
    public List<Cinemas> getAllCinemas() {
        return cinemasMapper.selectList(null);
    }

    @Override
    public PageInfo<Cinemas> getCinemasByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Cinemas> cinemasList = cinemasMapper.selectList(null);
        return new PageInfo<>(cinemasList);
    }

    @Override
    public List<Cinemas> getCinemasByName(String name) {
        return cinemasMapper.selectList(new QueryWrapper<Cinemas>().like("cin_name", name));
    }

    @Override
    public List<Cinemas> getCinemasByAddress(String address) {
        return cinemasMapper.selectList(new QueryWrapper<Cinemas>().like("cin_address", address));
    }
}




