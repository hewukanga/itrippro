package com.itrip.dao;

import com.itrip.model.ItripImage;
import java.util.List;

public interface ItripImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripImage record);

    ItripImage selectByPrimaryKey(Long id);

    List<ItripImage> selectAll();

    int updateByPrimaryKey(ItripImage record);
}