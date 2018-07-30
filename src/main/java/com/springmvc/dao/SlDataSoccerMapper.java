package com.springmvc.dao;

import com.springmvc.pojo.SlDataSoccer;

import java.util.List;

public interface SlDataSoccerMapper {
    //根据id查询
    SlDataSoccer findById(String id);

    List<SlDataSoccer> findByNmber(String numberOfPeriods);
}
