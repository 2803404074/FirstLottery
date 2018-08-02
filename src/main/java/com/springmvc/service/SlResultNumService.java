package com.springmvc.service;

import com.springmvc.dao.SlResultNumMapper;
import com.springmvc.pojo.SlResultNumWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("SlResultNumService")
public class SlResultNumService {
    @Resource
    private SlResultNumMapper slResultNumMapper;

    public int insert(SlResultNumWithBLOBs withBLOBs) {
        int ret = this.slResultNumMapper.insert(withBLOBs);
        if (ret > 0) {
            return ret;
        }
        return 0;
    }

    public List findNumById(String id){
        List<SlResultNumWithBLOBs> list = slResultNumMapper.findNumById(id);
        if(list!=null){
            return list;
        }
        return null;
    }
}
