%@ page import="com.util.WebUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.PhoneInfo" %>
<%@ page import="com.util.WebUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 9470
  Date: 2018/8/27
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>冒牌手机</title>
</head>
<body>
<%= WebUtil.popSessionMsg(request) %>

<form action="/phone/del" method="post">
    <table class="table table-striped">
        <tr>
            <th><input type="checkbox" onclick="checkboxs(this)"></th>
            <th>序号</th>
            <th>手机名</th>
            <th>价格</th>
            <th>品牌</th>
            <th>其他</th>
        </tr>

        <c:forEach var="item" items="${requestScope.phoneInfoList}" varStatus="vs">
            <tr>
                <td><input name="id" value=${item.id} type="checkbox"></td>
                <td>${item.id}</td>
                <td><a href="<c:url value="/phone/detail?id=${item.id}" />">${item.name}</a></td>
                <td><f:formatNumber value="${item.price}" type="CURRENCY" currencySymbol="$"/></td>
                <td>${item.brand}</td>
                <td>
                    <a href="<c:url value="/phone/del?id=${item.id}"/>">删除</a>
                    <a href="#myModal" data-toggle="modal" data-id="${item.id}">更新</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div style="margin-top: 2em;">
        <input type="submit" value="删除" class="btn btn-danger">
        <a class="btn btn-primary" href="/phone/add">新增书籍</a>
    </div>
</form>

<%@include file="phone_update_modal.jsp" %>
<script>
    $("#myModal").on("show.bs.modal", function (e) {
        //ajax获取数据
        var a=event.target;
        var $a=$(a);
        // console.log($(a).attr("data-id"));
        $.post("/phone/PhoneById",{id:$(a).attr("data-id")},function (data) {
            //         /* $("#id").val(data.id);
            //          $("#name").val(data.name);
            //          $("#price").val(data.price);
            //          $("#brand").val(data.brand);*/
            //
            document.getElementById("phoneId").value=data.id;
            document.getElementById("phonename").value=data.name;
            document.getElementById("phoneprice").value=data.price;
            document.getElementById("phonebrand").value=data.brand;
        });
    });

    function checkboxs(e) {
        var checkbox = document.getElementsByName("id");
        for (var i = 0; i < checkbox.length; i++) {
            checkbox[i].checked = e.checked
        }
    }

    document.querySelector("#phonelist").classList.add("active");
</script>
<script>
    document.querySelector("#phoneadd").classList.add("active");
</script>
</body>
</html>