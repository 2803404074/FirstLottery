package com.springmvc.controller;

import com.springmvc.pojo.SlUser;
import com.springmvc.service.SlUserService;
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

    @Resource
    SlUserService userService;
//
//
//    @RequestMapping("/login")
//    @ResponseBody
//    public void login(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            response.setContentType("text/html;charset=utf-8");
//            request.setCharacterEncoding("utf-8");
//            String name =  request.getParameter("username");
//            String pass =  request.getParameter("password");
//            boolean ret = userService.login(name,pass);
//            if(ret){
//                //登陆成功
//            }else{
//                //登陆失败
//
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/regist")
//    @ResponseBody
//    public void regist(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            response.setContentType("text/html;charset=utf-8");
//            request.setCharacterEncoding("utf-8");
//            String name =  request.getParameter("username");
//            String pass =  request.getParameter("password");
//            SlUser slUser = new SlUser();
//            int ret = userService.insertUser(slUser);
//            if(ret>0){
//                //注册成功
//            }else{
//                //注册失败
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
