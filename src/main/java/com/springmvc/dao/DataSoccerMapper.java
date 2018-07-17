package com.springmvc.dao;

import com.springmvc.pojo.DataSoccer;

public interface DataSoccerMapper {
    //根据id查询
    DataSoccer findById(String id);
}
