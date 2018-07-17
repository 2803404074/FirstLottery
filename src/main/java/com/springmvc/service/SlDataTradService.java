package com.springmvc.service;


import com.springmvc.dao.SlDataTradMapper;
import com.springmvc.pojo.SlDataTradWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}