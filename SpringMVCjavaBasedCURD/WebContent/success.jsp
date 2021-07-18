<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function addUser() {
	
	document.fn.action="registration.jsp";
	document.fn.submit();
}
function deleteUser() {
	
	document.fn.action="delete";
	document.fn.submit();
}
function editUser() {

	document.fn.action="edit";
	document.fn.submit();
}

</script>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
</head>
<body>

	<form  name="fn">


		<table border="1" align="center">
		<tr>
			<th>Sr No</th>
			<th>Id</th>
			<th>Name</th>
			<th>User Name</th>
			<th>Password</th>
			<th>Mobile No</th>
			</tr>
				<c:forEach items="${data}" var="user">
				<tr>
					
					<td><input type="radio" name="id" value="${user.id}"></td>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.uname}</td>
					<td>${user.pass}</td>
					<td>${user.mob}</td>
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