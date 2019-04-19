package com.itrip.dao;

import com.itrip.model.ItripUser;
import java.util.List;

public interface ItripUserMapper {
    int deleteByPrimaryKey(Long id);

    boolean insert(ItripUser record);

    ItripUser selectByPrimaryKey(Long id);

    List<ItripUser> selectAll();

    int updateByPrimaryKey(ItripUser record);
}