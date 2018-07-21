<%@ page import="com.springmvc.pojo.SlDataSoccer" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<table border="1" cellspacing="0" cellpadding="0" width="800px" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
        <th>赛事编号</th><th>赛事</th><th>开赛时间</th><th>主队VS客队</th><th>全部</th><th width="100" colspan="3">胜&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp平&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp负</th></tr>
    <tr style="text-decoration: none;text-align:center">
        <td rowspan="3">${numId}</td><td rowspan="3">${eventType}</td><td rowspan="3">${startDate} <br>  ${startTime}</td>
        <td rowspan="3">${home}VS${visitor}</td><td rowspan="3">dwd</td>
    </tr>

    <tr style="font-weight:bold;">
        <td>qqqq</td><td>qqqq</td><td>qqqq</td>
    </tr>
    <tr style="font-weight:bold;">
        <td>qqqq</td><td>qqqq</td><td>qqqq</td>
    </tr>

    <%--*************************************--%>
    <tr style="font-weight:bold;">
        <td rowspan="3">${user1}</td><td rowspan="3" style="background: ${user5}">${user2}</td><td rowspan="3">${user3}</td>
        <td rowspan="3">${user4}</td><td rowspan="3">1111</td>
    </tr>

    <tr style="font-weight:bold;">
        <td>qqqq</td><td>qqqq</td><td>qqqq</td>
    </tr>
    <tr style="font-weight:bold;">
        <td>qqqq</td><td>qqqq</td><td>qqqq</td>
    </tr>
    <%--*************************************--%>
    <tr style="font-weight:bold;">
        <td rowspan="3">${user1}</td><td rowspan="3" style="background: ${user5}">${user2}</td><td rowspan="3">${user3}</td>
        <td rowspan="3">${user4}</td><td rowspan="3">1111</td>
    </tr>

    <tr style="font-weight:bold;">
        <td>qqqq</td><td>qqqq</td><td>qqqq</td>
    </tr>
    <tr style="font-weight:bold;">
        <td>qqqq</td><td>qqqq</td><td>qqqq</td>
    </tr>
</table>
</body>
</html>