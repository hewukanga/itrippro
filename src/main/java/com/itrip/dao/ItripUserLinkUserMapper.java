package com.itrip.dao;

import com.itrip.model.ItripUserLinkUser;
import java.util.List;

public interface ItripUserLinkUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripUserLinkUser record);

    ItripUserLinkUser selectByPrimaryKey(Long id);

    List<ItripUserLinkUser> selectAll();

    int updateByPrimaryKey(ItripUserLinkUser record);
}