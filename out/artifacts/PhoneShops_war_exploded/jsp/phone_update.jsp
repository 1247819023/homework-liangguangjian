<%@ page import="com.entity.PhoneInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍修改表单</title>
</head>
<body>

<% PhoneInfo phoneInfo = (PhoneInfo) request.getAttribute("phoneInfo"); %>

<form action="/phone/update" method="post">
    <div><input type="text" name="name" placeholder="name" value="<%= phoneInfo.getName()%>"></div>
    <div><input type="number" step="0.01" name="price" placeholder="price" value="<%= phoneInfo.getPrice()%>"></div>
    <div><input type="text" name="brand" placeholder="brand" value="<%= phoneInfo.getBrand()%>"></div>
    <div><input type="hidden" name="id" value="<%= phoneInfo.getId()%>"></div>

    <div><input type="submit" value="提交更新"></div>
</form>

</body>
</html>
