<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Page</title>
</head>
<body>

	<form action="FormData.jsp" method = "post">
<center>
		<table>

			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstName"
					placeholder="Enter First Name"></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastName"
					placeholder="Enter Last Name"></td>
			</tr>
			<tr>
				<th>Gmail</th>
				<td><input type="email" name="loginId"
					placeholder="Enter email Address"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					placeholder="Enter your Password"></td>

			</tr>
			<tr>
				<th>DOB</th>
				<td><input type="date" name="dob"></td>
			</tr>


			<tr>
				<th>Click here</th>
				<td><input type="submit" value="submit"></td>
			</tr>

		</table>
</center>
	</form>


</body>
</html>