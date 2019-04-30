package com.itrip.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itrip.dao.ItripHotelMapper;
import com.itrip.model.ItripHotel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripHotelService {
    @Resource
    private ItripHotelMapper itripHotelMapper;

    /**
     * 按条件查询酒店
     * @param name
     * @param hotellevel
     * @param details
     * @return
     */
    public List<ItripHotel> findBy(String name, int hotellevel, String details){
//        PageHelper.startPage(1,4);
        List<ItripHotel> list=itripHotelMapper.selectBy(name,hotellevel,details);
      //  PageInfo<ItripHotel> page=new PageInfo<ItripHotel>(list);
        return list;
    }

    /**
     * 查找酒店详情
     */
    public ItripHotel findDetail(String hotelname){
        return itripHotelMapper.selectDetail(hotelname);
    }

    public List<ItripHotel> findId(long id){
        return itripHotelMapper.selectId(id);
    }


}
