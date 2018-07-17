package com.springmvc.test;

import com.springmvc.dao.SlDataSoccerMapper;
import com.springmvc.pojo.SlDataSoccer;
import com.springmvc.service.SlDataSoccerService;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class UserTest {

    private Logger logger = Logger.getRootLogger();
    private ApplicationContext context;
    private SqlSessionFactory sessionFactory;
    private SlDataSoccerMapper mapper;
    @Resource
    SlDataSoccerService dataSoccerService;
    @Before
    public void init(){
        String configLocation = "spring-mybatis.xml";
        context = new ClassPathXmlApplicationContext(configLocation);
        sessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
    }

    @Test
    public void testClien(){
        mapper=sessionFactory.openSession().getMapper(SlDataSoccerMapper.class);

        SlDataSoccer ret = mapper.findById("fb201806225024");
        if(ret!=null){
            logger.info("成功");
            JSONObject dataObject = JSONObject.fromObject(ret);
            logger.info(dataObject.toString());

        }else{
            logger.info("失败");
        }

    }
}
