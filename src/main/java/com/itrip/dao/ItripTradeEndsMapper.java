package com.itrip.dao;

import com.itrip.model.ItripTradeEnds;
import java.util.List;

public interface ItripTradeEndsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripTradeEnds record);

    ItripTradeEnds selectByPrimaryKey(Long id);

    List<ItripTradeEnds> selectAll();

    int updateByPrimaryKey(ItripTradeEnds record);
}