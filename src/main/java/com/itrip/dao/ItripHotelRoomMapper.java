package com.itrip.dao;

import com.itrip.model.ItripHotelRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItripHotelRoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotelRoom record);

    ItripHotelRoom selectByPrimaryKey(Long id);

    List<ItripHotelRoom> selectAll();

    int updateByPrimaryKey(ItripHotelRoom record);
    List<ItripHotelRoom> selectByHotel(Long hotelid);
}