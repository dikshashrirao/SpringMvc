<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
<table border="1">

<input type="hidden" name="id" value="${data.id}">

<tr>
<td>Name:-</td>
<td><input type="text" name="name" value="${data.name}"></td>
</tr>
<tr>
<td>User Name:-</td>
<td><input type="text" name="uname" value="${data.uname}"></td>
</tr>
<tr>
<td>Password:-</td>
<td><input type="text" name="pass" value="${data.pass}"></td>
</tr>
<tr>
<td>Address:-</td>
<td><input type="text" name="mob" value="${data.mob}"></td>
</tr>
<tr>
<td><input type="submit" value="UPDATE"></td>
</tr>
</table>
</form>
</body>
</html>