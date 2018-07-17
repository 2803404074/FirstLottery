package com.springmvc.dao;

import com.springmvc.pojo.UserInfo;

/**
 * 彩民用户信息接口(登陆、注册、查询)
 */
public interface UserMapper {
    //添加彩民
    boolean addUser(UserInfo userInfo);

    //彩民登陆
    UserInfo Login(String userName,String userPassword);

    //根据用户名查询彩民信息
    UserInfo selectByName(String userName);

    //根据ID删除彩民
    int deleUser(int userId);

    //修改彩民
    boolean updataInfo(UserInfo userInfo);
}
