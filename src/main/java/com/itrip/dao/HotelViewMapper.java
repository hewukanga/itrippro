package com.itrip.dao;

import com.itrip.model.HotelView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelViewMapper {
    List<HotelView> selectBy(@Param("cityid") Long cityid);
    HotelView selectHotel(@Param("id")long id);
}
