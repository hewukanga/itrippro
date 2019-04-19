package com.itrip.dao;

import com.itrip.model.ItripHotelExtendProperty;
import java.util.List;

public interface ItripHotelExtendPropertyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotelExtendProperty record);

    ItripHotelExtendProperty selectByPrimaryKey(Long id);

    List<ItripHotelExtendProperty> selectAll();

    int updateByPrimaryKey(ItripHotelExtendProperty record);
}