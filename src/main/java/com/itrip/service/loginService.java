package com.itrip.service;

import com.itrip.dao.ItripUserMapper;
import com.itrip.model.ItripUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginService {
    @Autowired
    private ItripUserMapper iudao;
    public ItripUser loginUser(String name,String pwd){
        ItripUser user = new ItripUser();
        user.setUsercode(name);
        user.setUserpassword(pwd);
        return  iudao.loginuser(user);
    }
}
