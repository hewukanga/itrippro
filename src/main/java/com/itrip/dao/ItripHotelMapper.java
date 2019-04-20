package com.itrip.dao;

import com.itrip.model.ItripHotel;
import java.util.List;

public interface ItripHotelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotel record);

    ItripHotel selectByPrimaryKey(Long id);

    List<ItripHotel> selectAll();

    int updateByPrimaryKey(ItripHotel record);
    List<ItripHotel> selectBy(String name,int hotellevel,String details);
}