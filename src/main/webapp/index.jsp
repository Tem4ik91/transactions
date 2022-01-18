<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>title</title>
</head>
<body>
<tr>
    <td>id</td>
    <td>users</td>
</tr>
<form method="get" action="/save">
    <input type="text" name="id">
    <input type="text" name="login">
    <input type="submit" name="add" value="add">
    <input type="submit" name="showAll" value="showAll">
</form>
<tr>
    <td>id</td>
    <td>roles</td>
</tr>
<form method="get" action="/save">
    <input type="text" name="idR">
    <input type="text" name="name">
    <input type="submit" name="addR" value="add">
    <input type="submit" name="showAllR" value="showAll">
</form>
</body>
</html>