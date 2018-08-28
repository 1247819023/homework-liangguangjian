<%--
  Created by IntelliJ IDEA.
  User: 9470
  Date: 2018/8/26
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加手机</title>
    <meta name="subtitle" content="新增手机">
</head>
<body>

<form action="/phone/add" method="post">
    <div class="form-group">
        <label for="id">手机序号</label>
        <input type="number" class="form-control" id="id" name="id" placeholder="id">
    </div>
    <div class="form-group">
        <label for="name">手机名字</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="name">
    </div>
    <div class="form-group">
        <label for="price">手机价格</label>
        <input type="number" class="form-control" id="price" name="price" placeholder="price">
    </div>
    <div class="form-group">
        <label for="brand">手机品牌</label>
        <input type="text" class="form-control" id="brand" name="brand" placeholder="brand">
    </div>
    <div><input type="submit" class="form-control"></div>
</form>

<script>
    document.querySelector("#phoneadd").classList.add("active");
</script>

</body>
</html>
