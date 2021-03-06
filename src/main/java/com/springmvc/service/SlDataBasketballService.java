package com.springmvc.service;

import com.springmvc.dao.SlDataBasketballMapper;
import com.springmvc.pojo.SlDataBasketball;
import com.springmvc.pojo.SlDataBasketballWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SlDataBasketballService")
public class SlDataBasketballService {
    @Resource
    private SlDataBasketballMapper basketballMapper;

    public int insert(SlDataBasketballWithBLOBs withBLOBs) {
        int ret = this.basketballMapper.insert(withBLOBs);
        if (ret > 0) {
            return ret;
        }
        return 0;
    }

    public List findById(String id){
        List<SlDataBasketballWithBLOBs> list =  this.basketballMapper.findById(id);
        if (list!=null){
            return list;
        }
        return null;
    }
}
