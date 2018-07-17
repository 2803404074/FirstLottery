package com.springmvc.controller;

import com.springmvc.pojo.SlDataSoccer;
import com.springmvc.service.SlDataSoccerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class SlDataSoccerController {

    @Resource
    SlDataSoccerService dataSoccerService;

    @RequestMapping("/getInfo")
    @ResponseBody
    public SlDataSoccer login(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            SlDataSoccer dataSoccer = dataSoccerService.findById("fb201806225024");
            if(dataSoccer!=null){
                System.out.println(dataSoccer);
                return dataSoccer;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
