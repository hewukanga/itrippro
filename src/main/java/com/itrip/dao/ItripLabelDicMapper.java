package com.itrip.dao;

import com.itrip.model.ItripLabelDic;
import java.util.List;
import java.util.Map;

public interface ItripLabelDicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripLabelDic record);

    ItripLabelDic selectByPrimaryKey(Long id);

    List<ItripLabelDic> selectAll();

    int updateByPrimaryKey(ItripLabelDic record);

    ItripLabelDic selectSelf();
}