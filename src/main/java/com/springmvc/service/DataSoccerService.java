package com.springmvc.service;

import com.springmvc.dao.DataSoccerMapper;
import com.springmvc.pojo.DataSoccer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("DataSoccerService")
public class DataSoccerService {
    @Resource
    private DataSoccerMapper dataSoccerMapper;

    //注册
    public DataSoccer findById(String id){
        DataSoccer dataSoccer= (DataSoccer) this.dataSoccerMapper.findById(id);
        if(dataSoccer!=null){
            return dataSoccer;
        }

        return null;
    }
}
