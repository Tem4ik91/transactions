<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 15.01.2022
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <th>${list.id}</th>
            <th>${list.login}</th>
            <th><a href="/save?action=update&id=<c:out value="${list.id}"/>">update</a> </th>
            <th><a href="/save?action=delete&id=${list.id}">delete</a> </th>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td>id</td>
        <td>roles</td>
    </tr>
    <c:forEach items="${listR}" var="listR">
        <tr>
            <th>${listR.id}</th>
            <th>${listR.name}</th>
            <th><a href="/save?action=updateR&id=<c:out value="${listR.id}"/>">update</a> </th>
            <th><a href="/save?action=deleteR&id=${listR.id}">delete</a> </th>
        </tr>
    </c:forEach>
</table>


</body>
</html>
