<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 16.01.2022
  Time: 21:11
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
<form method="post" action="/save">
    <label>
        <input type="text" name="id" value="<c:out value="${roles.id}"/>">
    </label>
    <label>
        <input type="text" name="name" value="<c:out value="${roles.name}"/>">
    </label>
    <input type="submit" value="ok" name="updateR">
</form>
</body>
</html>