package com.springmvc.service;


import com.springmvc.dao.SlDataTradMapper;
import com.springmvc.pojo.SlDataTradWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SlDataTradService")
public class SlDataTradService {
    @Resource
    private SlDataTradMapper tradMapper;

    public int insert(SlDataTradWithBLOBs withBLOBs) {
        int ret = this.tradMapper.insert(withBLOBs);
        if (ret > 0) {
            return ret;
        }
        return 0;
    }

    public List findByDate(String starTime){
        List<SlDataTradWithBLOBs> ret= this.tradMapper.findByDate(starTime);
        if(ret!=null){
            return ret;
        }
        return null;
    }
}