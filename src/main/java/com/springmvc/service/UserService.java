package com.springmvc.service;

import com.springmvc.dao.UserMapper;
import com.springmvc.pojo.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserService {
    @Resource
    private UserMapper userMapper;

    //注册
    public UserInfo addUser(UserInfo userInfo){
        boolean a=this.userMapper.addUser(userInfo);
        if(a){
            return userInfo;
        }
        return null;
    }

    //登陆
    public UserInfo userLogin(String userName,String userPassword){
        UserInfo userInfo = this.userMapper.Login(userName,userPassword);
        if(userInfo!=null){
            return userInfo;
        }
        return null;
    }

}
