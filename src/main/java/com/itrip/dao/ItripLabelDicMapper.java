package com.itrip.dao;

import com.itrip.model.ItripLabelDic;
import java.util.List;

public interface ItripLabelDicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripLabelDic record);

    ItripLabelDic selectByPrimaryKey(Long id);

    List<ItripLabelDic> selectAll();

    int updateByPrimaryKey(ItripLabelDic record);
}