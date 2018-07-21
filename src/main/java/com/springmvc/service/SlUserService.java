package com.springmvc.service;


import com.springmvc.dao.SlUserMapper;
import com.springmvc.pojo.SlUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("SlUserService")
public class SlUserService {
    @Resource
    private SlUserMapper slUserMapper;

    //查询
    public SlUser findById(int uId) {
        SlUser slUser = (SlUser) this.slUserMapper.findUserById(uId);
        if (slUser != null) {
            return slUser;
        }
        return null;
    }

    //添加
    public int insertUser(SlUser record){
        int ret = this.slUserMapper.insert(record);
        if(ret>0){
            return 1;
        }
        return 0;
    }

    //登陆
    public boolean login(String uName,String uPassword){
        boolean ret = this.slUserMapper.login(uName,uPassword);
        if(ret){
            return ret;
        }
        return ret;
    }
}