<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function viewAllUser() {
	document.fn.action="viewall";
	document.fn.submit();
}
</script>
</head>
<body>
<form action="reg" name="fn">
  <table>
    <table border="1" align="center">
			<tr>
				<td>ID:-</td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>Mobile NO:-</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>NAME:-</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>PASSWORD:-</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>UNAME:-</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>CITY:-</td>
				<td><input type="text" name="ad.city"></td>
			</tr>
			<tr>
				<td>AREA:-</td>
				<td><input type="text" name="ad.area"></td>
			</tr>
			<tr>
				<td><input type="button" value="ViewAll" onclick="viewAllUser()"></td>
				
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
  </table>
</form>
</body>
</html>