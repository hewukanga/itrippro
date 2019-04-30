package com.itrip.dao;

import com.itrip.model.ItripUser;
import java.util.List;

public interface ItripUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItripUser record);

    ItripUser selectByPrimaryKey(Integer id);

    List<ItripUser> selectAll();

    int updateByPrimaryKey(ItripUser record);

    ItripUser loginuser(ItripUser user);
}