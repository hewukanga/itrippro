package com.itrip.service;

import com.itrip.dao.ItripAreaDicMapper;
import com.itrip.model.ItripAreaDic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripDicService {
    @Resource
    private ItripAreaDicMapper dao;

    public List<ItripAreaDic> findSea(){
        return dao.selectSea();
    }
    public List<ItripAreaDic> findHot(){
        return dao.selectHot();
    }
}
