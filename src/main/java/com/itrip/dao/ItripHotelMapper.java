package com.itrip.dao;

import com.itrip.model.ItripHotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItripHotelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotel record);

    ItripHotel selectByPrimaryKey(Long id);

    List<ItripHotel> selectAll();

    int updateByPrimaryKey(ItripHotel record);
    List<ItripHotel> selectBy(@Param("name") String name, @Param("hotellevel")int hotellevel,@Param("details") String details);
    ItripHotel selectDetail(@Param("hotelname")String hotelname);

    List<ItripHotel> selectId(@Param("id")long id);
}