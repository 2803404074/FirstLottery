package com.springmvc.controller;

import com.springmvc.model.FB_BfInfo;
import com.springmvc.pojo.SlDataSoccer;
import com.springmvc.service.SlDataSoccerService;
import com.springmvc.utils.JsonTransformation;
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
 * 获取比分赔率接口
 */
@Controller
public class FbBfController {
    private JSONObject jsonObject;
    List<Object> lists = new ArrayList<Object>();
    JSONArray array = new JSONArray();

    @Resource
    SlDataSoccerService dataSoccerService;

    @RequestMapping("/getOddsBfInfo")
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
                    String str = slDataSoccer.getContents();//contents字段为json字符串，需解析
                    jsonInfo(str);//解析

                } else {
                    System.out.println("查询失败");
                }
            }
            jsonObject.put("bfOdds",array);
            out.println(jsonObject);
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void jsonInfo(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);//第二层
        Iterator iterator = jsonObject.keys();
        FB_BfInfo FBBfInfo = new FB_BfInfo();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);
            //id
            if("id".equals(key)){
                FBBfInfo.setId(value);
            }
            //比分赔率
            if ("current_bf".equals(key)) {
                JSONObject changName = getJson(value,1);
                FBBfInfo.setCurrent_bf(changName);
            }
        }
        lists.clear();
        lists.add(FBBfInfo);
        for (int i=0;i<lists.size();i++){
            array.add(lists.get(i));
        }
    }

    private JSONObject getJson(String json, int index) {
        JSONObject jsonObjectss = new JSONObject();
        JSONObject jsonObject2 = JSONObject.fromObject(json);//第三层
        Iterator iterator2 = jsonObject2.keys();
        while (iterator2.hasNext()) {
            String key2 = (String) iterator2.next();
            String value2 = jsonObject2.getString(key2);
            if (index == 0) {
                System.out.println("还有json:key=" + key2 + ",value=" + value2);
            } else {
                System.out.println("解析指定json数据:key=" + key2 + ",value=" + value2);
                JsonTransformation jf = new JsonTransformation();
                String keyName = jf.bfKeyName(key2);
                jsonObjectss.put(keyName,value2);
            }
        }
        System.out.println("转换后："+jsonObjectss.toString());
        return jsonObjectss;
    }
}
