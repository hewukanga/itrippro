package com.itrip.service;

import com.itrip.dao.ItripCommentMapper;
import com.itrip.model.ItripComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {
    @Resource
    private ItripCommentMapper dao;

    public List<ItripComment> findByHotel(Long hotelid){
        return dao.selectByHotel(hotelid);
    }
}
