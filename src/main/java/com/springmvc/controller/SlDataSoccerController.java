package com.springmvc.controller;

import com.springmvc.pojo.SlDataSoccer;
import com.springmvc.service.SlDataSoccerService;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.*;

@Controller
public class SlDataSoccerController {
    private Map<String, String> map = new HashMap<String, String>();
    private List<Object> list = new ArrayList<>();
    @Resource
    SlDataSoccerService dataSoccerService;

    @RequestMapping("/getInfo")
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            HttpSession session = request.getSession();
            SlDataSoccer dataSoccer1 = dataSoccerService.findById("fb201807172101");
            if(dataSoccer1!=null){
                session.setAttribute("numId",dataSoccer1.getNumId());
                session.setAttribute("eventType",dataSoccer1.getEventType());
                session.setAttribute("startDate",dataSoccer1.getStartDate());
                session.setAttribute("startTime",dataSoccer1.getStartTime());
                session.setAttribute("home",dataSoccer1.getHome());
                session.setAttribute("visitor",dataSoccer1.getVisitor());
                session.setAttribute("color",dataSoccer1.getEventBgColor());
                String str = dataSoccer1.getContents();//contents字段为json字符串，需解析
                jsonInfo(str);//解析
                request.getRequestDispatcher("imgloder.jsp").forward(request,response);
            }else{
                System.out.println("查询失败");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void jsonInfo(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);//第二层
        Iterator iterator = jsonObject.keys();

        while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);
            System.out.println("key值:"+key+"-------value值:"+value);
            boolean ret = isJson(value);
            if(ret){
                JSONObject jsonObject2 = JSONObject.fromObject(value);//第三层
                Iterator iterator2 = jsonObject2.keys();
                while (iterator2.hasNext()){
                    String key2 = (String) iterator2.next();
                    String value2 = jsonObject2.getString(key2);
                    System.out.println("还有json:key="+key2+",value="+value2);
                }
            }
        }
    }

    //判断字符串是否是合法的json字符串
    public static boolean isJson(String content) {
        try {
            JSONObject.fromObject(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
