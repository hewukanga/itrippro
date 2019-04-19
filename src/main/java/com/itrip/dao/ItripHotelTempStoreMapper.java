package com.itrip.dao;

import com.itrip.model.ItripHotelTempStore;
import java.util.List;

public interface ItripHotelTempStoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotelTempStore record);

    ItripHotelTempStore selectByPrimaryKey(Long id);

    List<ItripHotelTempStore> selectAll();

    int updateByPrimaryKey(ItripHotelTempStore record);
}