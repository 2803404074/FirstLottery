package com.springmvc.dao;

import com.springmvc.pojo.SlDataSoccer;

import java.util.Date;
import java.util.List;

public interface SlDataSoccerMapper {
    //根据id查询
    List<SlDataSoccer> findByDate(String date);

    List<SlDataSoccer> findByNmber(String numberOfPeriods);
}
