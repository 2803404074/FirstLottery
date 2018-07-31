<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <title>欢迎登录</title>
    <link href="css/index.css" rel="stylesheet"></head>
<body>
<!--面板-->
<div id="panel">
    <!--面板的头部-->
    <div class="panel-top">
        <h2>欢迎登录体育彩票系统</h2>
    </div>    <!--面板的主要内容-->
    <form class="panel-content" action="/login.do">
        <div class="int">
            <label><img src="images/user.png" ></label>
            <input type="text" id="phone" placeholder="你的手机号/用户名">
        </div>
        <div class="int">
            <label><img src="images/user.png" ></label>
            <input type="password" id="pass" placeholder="输入密码">
        </div>
        <!--配置信息-->
        <div class="setting">
            <a href="#" class="auto-login">
                <input type="checkbox">下次自动登录
            </a>
            <a href="#" class="forget-pwd">忘记密码</a>
        </div>
        <div class="login">
            <button type="submit">登录</button>
        </div>
        <div class="reg">还没账号?<a href="#">马上注册</a>
        </div>
    </form>
    <!--面板的底部-->
    <div class="panel-footer">
        <span>社交账号登录:</span>
        <img src="images/user.png">
        <img src="images/user.png">
        <img src="images/user.png">
    </div>
</div>
</body>
<style>

    a, address, b, big, blockquote, body, center, cite, code, dd, del, div, dl, dt, em, fieldset, font, form, h1, h2, h3, h4, h5, h6, html, i, iframe, img, ins, label, legend, li, ol, p, pre, small, span, strong, u, ul, var{
        padding: 0;
        margin: 0;
    }
    /*去掉 内外边距*/
    *{
        padding: 0;
        margin: 0;
    }
    /*设置这个整体的容器的背景色*/
    body{
        background-color: #F2F2F2;
        /*让其水平居中*/
        text-align: center;
    }
    /*面板*/
    #panel{
        /*最大的容器距离顶部50个像素*/
        margin-top: 50px;
        display: inline-block;
        background-color: white;
        border: 1px solid #dddddd ;
        padding: 30px;
        border-radius: 6px;
        /*水平 和垂直都是0  2个像素*/
        /*设置阴影*/
        box-shadow: 0 0 10px #999;
        width: 260px;
    }
    /*面板头部*/
    #panel .panel-top{
        font-size: 13px;
        font-family: Arial;
        font-weight: normal;
        padding: 10px 0;
        border-bottom: 1px solid #dddddd;
        width: 220px;
        margin: 0 auto;
    }
    /*面板中间*/
    #panel .panel-content{
        margin-top: 20px;
    }
    #panel .panel-content .int{
        height: 36px;
        margin-bottom: 9px;
        position: relative;
    }
    #panel .panel-content label{
        position: absolute;    top: 7px;
        left: 6px;
    }
    #panel .panel-content .int input{
        width: 100%;
        height: 100%;
        border: 1px solid #dddddd;
        padding-left: 40px;
        /*输入框不超出设置的最大容器*/
        box-sizing: border-box;
        border-radius: 6px;
    }
    #panel .panel-content input:focus{
        /*取消边框*/
        outline: none;
        border: 1px solid orangered;
        box-shadow: 0 0 2px orangered;
    }
    #panel .panel-content .pwd-login a{
        display: inline-block;
        color: gray;
        font-size: 13px;
    }
    #panel .panel-content .pwd-login{
        width: 260px;
        height: 30px;
        line-height: 30px;
    }
    #panel .panel-content .setting{
        background-color: red;
    }
    #panel .panel-content .setting .forget-pwd{    float: right;
    }
    #panel .panel-content .setting .auto-login{    float: left;
        text-decoration: none;
    }
    #panel .panel-content .pwd-login  input{
        /*设置行内块级标签*/
        display: inline-block;
        width: 18px;
        float: left;
    }
    #panel .login button{
        margin-top: 20px;
        width: 100%;
        height: 33px;
        border: 0;
        color: white;
        font-size: 18px;
        margin-bottom: 10px;
        border-radius: 6px;
        background-color: orangered;
    }
    #panel .reg{
        height: 30px;
        line-height: 30px;
        font-size: 13px;
    }
    #panel .reg a{
        color: orangered;
        text-decoration: none;
        margin-left: 5px;
    }
    #panel .panel-footer{
        height: 40px;
        line-height: 40px;
    }
    #panel .panel-footer img{
        /*设置图片居中*/
        vertical-align: middle;
    }
    #panel .panel-footer span{
        /*设置文字垂直居中*/
        vertical-align: middle;
    }
</style>
</html>
