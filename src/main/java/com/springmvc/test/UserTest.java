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
import java.util.*;

public class UserTest {

    private Logger logger = Logger.getRootLogger();
    private ApplicationContext context;
    private SqlSessionFactory sessionFactory;
    private  Map<String, String> map = new HashMap<String, String>();
    private List<Object> list = new ArrayList<>();
    //接口mapper
    private SlDataSoccerMapper mapper;
//    private SlUserMapper userMapper;
    @Before
    public void init(){
        String configLocation = "spring-mybatis.xml";
        context = new ClassPathXmlApplicationContext(configLocation);
        sessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
    }

    @Test
    public void testClien() throws IllegalAccessException {
        mapper=sessionFactory.openSession().getMapper(SlDataSoccerMapper.class);
        SlDataSoccer ret = mapper.findById("fb201806225024");
        Map map3 = new HashMap();

        if(ret!=null){
            Field[] fields = ret.getClass().getDeclaredFields();
            for (int i=0;i<fields.length;i++){
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                Object o = fields[i].get(ret);
                String name = fields[i].getName();
                if(name.equals("contents")){
                    getJson(o);
                }

                list.add(o);
                logger.info("存了"+o);
                fields[i].setAccessible(accessFlag);
            }
            logger.info(list.toString());
            for (int i = 0; i <list.size(); i++) {
                Object element = list.get(i);
                System.out.println("索引=" + i + ", 元素=" + element);
            }

            for(Map.Entry<String, String> entry:map.entrySet()){
                System.out.println(entry.getKey()+"/"+entry.getValue());
            }
            logger.info(map.size());
        }else{
            logger.info("失败");
        }
    }

    private void getJson(Object name) {
        JSONObject jsonObject = JSONObject.fromObject(name);
        Iterator iterator = jsonObject.keys();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);//这里可以根据实际类型去获取
            map.put(key,value);
        }
    }

//    @Test
//    public void testClien(){
//        userMapper = sessionFactory.openSession().getMapper(SlUserMapper.class);
//        SlUser slUser = new SlUser(3,"user3","333","333","333");
//        int ret = userMapper.insert(slUser);
//        if(ret!=0){
//            logger.info("插入成功");
//            logger.info(slUser.toString());
//            Field[] fields = slUser.getClass().getDeclaredFields();
//            for (int i=0;i<fields.length;i++){
//                String name = fields[i].getName();
//                logger.info(name+"\n");
//            }
//        }else{
//            logger.info("失败");
//        }
//    }
}
