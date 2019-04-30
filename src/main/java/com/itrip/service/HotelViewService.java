package com.itrip.service;

import com.itrip.dao.HotelViewMapper;
import com.itrip.model.HotelView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelViewService {
    @Resource
    private HotelViewMapper dao;

    public List<HotelView> findBy(long cityid){
        return dao.selectBy(cityid);
    }

    public HotelView findHotel(long id){
        return dao.selectHotel(id);
    }
}
