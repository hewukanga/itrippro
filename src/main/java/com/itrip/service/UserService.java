package com.itrip.service;

import com.itrip.dao.ItripUserMapper;
import com.itrip.model.ItripUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private ItripUserMapper dao;

    public ItripUser findUser(long id){
        return dao.selectByPrimaryKey(id);
    }
}
