package com.springmvc.service;


import com.springmvc.dao.SlUserMapper;
import com.springmvc.pojo.SlUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("SlUserService")
public class SlUserService {
    @Resource
    private SlUserMapper slUserMapper;

    //注册
    public SlUser findById(int uId) {
        SlUser slUser = (SlUser) this.slUserMapper.findUserById(uId);
        if (slUser != null) {
            return slUser;
        }
        return null;
    }
}