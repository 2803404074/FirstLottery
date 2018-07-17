package com.springmvc.dao;

import com.springmvc.pojo.SlDataSoccer;

public interface SlDataSoccerMapper {
    //根据id查询
    SlDataSoccer findById(String id);
}
