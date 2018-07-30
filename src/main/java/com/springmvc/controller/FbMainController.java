package com.springmvc.controller;

import com.springmvc.model.FB_MainInfo;
import com.springmvc.pojo.SlDataSoccer;
import com.springmvc.service.SlDataSoccerService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 获取可购买的主要信息
 */
@Controller
public class FbMainController {
    private JSONObject jsonObject;
    List<Object> lists = new ArrayList<Object>();
    JSONArray array = new JSONArray();
    @Resource
    private
    SlDataSoccerService dataSoccerService;

    @RequestMapping("/getMainInfo")
    @ResponseBody
    public void getInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            jsonObject = new JSONObject();
            String numberOfPeriods = request.getParameter("numberOfPeriods");
            List<SlDataSoccer> list = dataSoccerService.findByNmber(numberOfPeriods);
            for (SlDataSoccer slDataSoccer : list) {
                if (slDataSoccer != null) {
                    String id = slDataSoccer.getId();
                    String numId = slDataSoccer.getNumId();//赛事编号
                    String eventType = slDataSoccer.getEventType();//赛事
                    String startDate = slDataSoccer.getStartDate();//开赛时间（日期）
                    String startTime = slDataSoccer.getStartTime();//开赛时间（时分）
                    String home = slDataSoccer.getHome();//主队名称
                    String visitor = slDataSoccer.getVisitor();//客队名称
                    String eventBgColor = slDataSoccer.getEventBgColor();//赛事背景颜色
                    FB_MainInfo FB_MainInfo = new FB_MainInfo(id,numId,eventType,startDate,startTime,home,visitor,eventBgColor);
                    lists.clear();
                    lists.add(FB_MainInfo);
                    for (int i=0;i<lists.size();i++){
                        array.add(lists.get(i));
                    }
                } else {
                    System.out.println("查询失败");
                }
            }
            System.out.println("json信息"+array.toString());
            jsonObject.put("mainInfo",array);
            out.println(jsonObject);
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
