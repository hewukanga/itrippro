package com.itrip.service;

import com.itrip.dao.ItripLabelDicMapper;
import com.itrip.model.ItripLabelDic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class LabelDicService {
    @Resource
    private ItripLabelDicMapper dao;

    public ItripLabelDic findSelf(){
        return dao.selectSelf();
    }
}
