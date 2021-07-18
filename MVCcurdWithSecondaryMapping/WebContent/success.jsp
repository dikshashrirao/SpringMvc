<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success</title>
<script type="text/javascript">
function deleteUser() {
	document.fn.action="delete";
	document.fn.submit();
}
function editUser() {
	document.fn.action="edit";
	document.fn.submit();
}
function addUser() {
	document.fn.action="registration.jsp";
	document.fn.submit();
}
</script>
</head>
<body>
<form name="fn">
<table  border="1" align="center">
  <tr border="1" align="center">
   <th>Sr No</th>
    <th>Id</th>
    <th>Mobile No</th>
    <th>Name</th>
   <th>Password</th>
    <th>User Name</th>
    <th>City</th>
	<th>Area</th>
   </tr>
   <c:forEach items="${data}" var="user">
   <tr>
     <td><input type="radio" name="uid" value="${user.uid}"></td>
     <td>${user.uid}</td>
       <td>${user.mobile}</td>
     <td>${user.name}</td> 
     <td>${user.password}</td>
      <td>${user.uname}</td>
     <td>${user.ad.city}</td>
     <td>${user.ad.area}</td>
   </tr>
   </c:forEach>
</table>
<table border="2" align="center">
<tr>
<td><input type="button" value="EDIT" onclick="editUser()"></td>
<td><input type="button" value="ADD" onclick="addUser()"></td>
<td><input type="button" value="DELETE" onclick="deleteUser()"></td>
</tr>
</table>
</form>
</body>
</html>