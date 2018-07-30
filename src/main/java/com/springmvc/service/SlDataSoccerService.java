package com.springmvc.service;
import com.springmvc.dao.SlDataSoccerMapper;
import com.springmvc.pojo.SlDataSoccer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SlDataSoccerService")
public class SlDataSoccerService {
    @Resource
    private SlDataSoccerMapper slDataSoccerMapper;

    //根据id查询
    public SlDataSoccer findById(String id){
        SlDataSoccer dataSoccer= (SlDataSoccer) this.slDataSoccerMapper.findById(id);
        if(dataSoccer!=null){
            return dataSoccer;
        }
        return null;
    }

    //根据期号查询，模糊
    public List findByNmber(String numberOfPeriods){
        List<SlDataSoccer> dataSoccer= this.slDataSoccerMapper.findByNmber(numberOfPeriods);
        if(dataSoccer!=null){
                return dataSoccer;
        }
        return null;
    }
}
