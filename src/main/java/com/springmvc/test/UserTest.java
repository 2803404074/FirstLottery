package com.springmvc.test;

import com.springmvc.dao.SlDataSoccerMapper;
import com.springmvc.dao.SlDataTradMapper;
import com.springmvc.dao.SlUserMapper;
import com.springmvc.pojo.SlDataSoccer;
import com.springmvc.pojo.SlDataTrad;
import com.springmvc.pojo.SlDataTradWithBLOBs;
import com.springmvc.pojo.SlUser;
import com.springmvc.service.SlDataSoccerService;
import com.springmvc.service.SlDataTradService;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;

public class UserTest {

    private Logger logger = Logger.getRootLogger();
    private ApplicationContext context;
    private SqlSessionFactory sessionFactory;
    //接口mapper
    private SlDataTradMapper mapper;

    @Resource
    SlDataTradService service;
//    private SlUserMapper userMapper;
    @Before
    public void init(){
        String configLocation = "spring-mybatis.xml";
        context = new ClassPathXmlApplicationContext(configLocation);
        sessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
    }

    @Test
    public void testClien() throws IllegalAccessException {
        mapper = sessionFactory.openSession().getMapper(SlDataTradMapper.class);
        List<SlDataTradWithBLOBs> ret = mapper.findByDate("2018-07-29");
        for (SlDataTradWithBLOBs slDataTrad : ret) {
            logger.info(slDataTrad.getId());
        }
    }
}
