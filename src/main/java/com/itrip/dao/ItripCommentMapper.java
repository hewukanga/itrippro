package com.itrip.dao;

import com.itrip.model.ItripComment;
import java.util.List;

public interface ItripCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripComment record);

    ItripComment selectByPrimaryKey(Long id);

    List<ItripComment> selectAll();

    int updateByPrimaryKey(ItripComment record);
    List<ItripComment> selectByHotel(Long hotelid);
}