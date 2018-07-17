package com.springmvc.test;

import com.springmvc.dao.SlDataSoccerMapper;
import com.springmvc.dao.SlUserMapper;
import com.springmvc.pojo.SlDataSoccer;
import com.springmvc.pojo.SlUser;
import com.springmvc.service.SlDataSoccerService;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.lang.reflect.Field;

public class UserTest {

    private Logger logger = Logger.getRootLogger();
    private ApplicationContext context;
    private SqlSessionFactory sessionFactory;

    //接口mapper
    private SlDataSoccerMapper mapper;
    private SlUserMapper userMapper;
    @Before
    public void init(){
        String configLocation = "spring-mybatis.xml";
        context = new ClassPathXmlApplicationContext(configLocation);
        sessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
    }

//    @Test
//    public void testClien(){
//        mapper=sessionFactory.openSession().getMapper(SlDataSoccerMapper.class);
//        SlDataSoccer ret = mapper.findById("fb201806225024");
//        if(ret!=null){
//            logger.info("成功");
//            JSONObject dataObject = JSONObject.fromObject(ret);
//            logger.info(dataObject.toString());
//
//        }else{
//            logger.info("失败");
//        }
//    }

    @Test
    public void testClien(){
        userMapper = sessionFactory.openSession().getMapper(SlUserMapper.class);
        SlUser slUser = new SlUser(3,"user3","333","333","333");
        int ret = userMapper.insert(slUser);
        if(ret!=0){
            logger.info("插入成功");
            logger.info(slUser.toString());
            Field[] fields = slUser.getClass().getDeclaredFields();
            for (int i=0;i<fields.length;i++){
                String name = fields[i].getName();
                logger.info(name+"\n");
            }
        }else{
            logger.info("失败");
        }
    }
}
