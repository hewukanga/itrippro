package com.itrip.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itrip.dao.ItripHotelMapper;
import com.itrip.model.ItripHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItripHotelService {
    @Autowired
    private ItripHotelMapper itripHotelMapper;

    public PageInfo<ItripHotel> findBy(String name,int hotellevel,String details,int pageNo,int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<ItripHotel> list=itripHotelMapper.selectBy(name,hotellevel,details);
        PageInfo<ItripHotel> page=new PageInfo<ItripHotel>(list);
        return page;
    }
}
