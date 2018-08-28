<%--
  Created by IntelliJ IDEA.
  User: 9470
  Date: 2018/8/26
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.PhoneInfo" %>
<%@ page import="com.util.WebUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍详情</title>
    <style>
        .msg {
            font-size: 2em;
            color: greenyellow;
        }
    </style>
</head>
<body>

<%
    PhoneInfo phoneInfo = (PhoneInfo) request.getAttribute("phoneInfo");
%>

<%= WebUtil.popSessionMsg(request) %>

<h1><%=phoneInfo.getName()%></h1>
<ul class="list-group">
    <li class="list-group-item"><%=phoneInfo.getPrice()%></li>
    <li class="list-group-item"><%=phoneInfo.getBrand()%></li>
</ul>
</body>
</html>

