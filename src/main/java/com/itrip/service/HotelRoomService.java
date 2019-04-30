package com.itrip.service;

import com.itrip.dao.ItripHotelRoomMapper;
import com.itrip.model.ItripHotelRoom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelRoomService {
    @Resource
    private ItripHotelRoomMapper itripHotelRoomMapper;


    public List<ItripHotelRoom> findByHotel(Long hotelid){
        return itripHotelRoomMapper.selectByHotel(hotelid);
    }
}
