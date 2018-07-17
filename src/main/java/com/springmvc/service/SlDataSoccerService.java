package com.springmvc.service;
import com.springmvc.dao.SlDataSoccerMapper;
import com.springmvc.pojo.SlDataSoccer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("SlDataSoccerService")
public class SlDataSoccerService {
    @Resource
    private SlDataSoccerMapper slDataSoccerMapper;

    //注册
    public SlDataSoccer findById(String id){
        SlDataSoccer dataSoccer= (SlDataSoccer) this.slDataSoccerMapper.findById(id);
        if(dataSoccer!=null){
            return dataSoccer;
        }

        return null;
    }
}
