package com.itrip.service;

import com.itrip.dao.EvaluateMapper;
import com.itrip.dao.ItripHotelOrderMapper;
import com.itrip.dao.ItripUserMapper;
import com.itrip.model.Evaluate;
import com.itrip.model.ItripHotelOrder;
import com.itrip.model.ItripUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalCenterService {
    @Autowired
    private ItripUserMapper itripUserMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private ItripHotelOrderMapper itripHotelOrderMapper;

    public ItripUser findbyid(Integer id){//通过id查到用户
        return itripUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过用户id查到这个用户所有的酒店订单
     * @param uid
     * @return
     */
    public List<ItripHotelOrder> findbyuserid(Long uid){
        return itripHotelOrderMapper.selectbyuid(uid);
    }

    /**
     * 通过这个用户的所有酒店订单id  查到用户在酒店的评论
     * @param hid
     * @return
     */
    public Evaluate findbyhid(Long hid){
        return evaluateMapper.selectbyhid(hid);
    }
}
