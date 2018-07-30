package com.springmvc.controller;

import com.springmvc.pojo.SlUser;
import com.springmvc.service.SlUserService;
import net.sf.json.JSONObject;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 用户登陆、注册类
 */
@Controller
public class SlUserController {

    private JSONObject jsonObject;
    @Resource
    SlUserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request,
                      HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            String name =  request.getParameter("account");
            String pass =  request.getParameter("password");
            SlUser ret = userService.login(name,pass);
            if(ret!=null){
                //登陆成功
                return "ok";
            }else{
                //登陆失败
                return "error";

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
//
    @RequestMapping("/regist")
    @ResponseBody
    public JSONObject regist(HttpServletRequest request,
                             HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            jsonObject = new JSONObject();
            String name =  request.getParameter("name");
            String account =  request.getParameter("account");
            String pass =  request.getParameter("password");
            String phone =  request.getParameter("phone");

            SlUser slUser = new SlUser(name,account,pass,phone);
            int ret = userService.insertUser(slUser);
            if(ret>0){
                jsonObject.put("name",slUser.getuName());
                jsonObject.put("account",slUser.getuAccount());
                jsonObject.put("pass",slUser.getuPassword());
                jsonObject.put("phone",slUser.getuPhone());
            }else{
                //注册失败
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
