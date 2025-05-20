<%@page import="java.util.List"%>
<%@page import="com.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="Header.jsp"%>

	<form action="UserListCtl" method="post">

		<h1 align="center">User List</h1>
		<%
			List list = (List) request.getAttribute("list");
			String msg = (String) request.getAttribute("msg");
		%>

		<%
			if (msg != null) {
		%>
		<h1 align="center"><%=msg%></h1>
		<%
			}
		%>
		<table>

			<td><input type="text" name="firstname"
				placeholder="search by firstname"> &nbsp; <input type="text"
				name="lastname" placeholder="search by lastname"> &nbsp; <input
				type="text" name="loginId" placeholder="search by loginId">
				&nbsp; <input type="date" name="dob" placeholder="search by dob">
				&nbsp; <input type="submit" name="operation" value="search">
			</td>
			</tr>
		</table>
		<center>
			<tr>
				<table border="10px" width="100%">
					<tr style="background-color: skyblue">
						<th>Delete</th>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>LoginId</th>
						<th>DOB</th>
						<th>Edit</th>

					</tr>
					<%
						Iterator it = list.iterator();

						while (it.hasNext()) {
							UserBean bean = (UserBean) it.next();
					%>
					<tr align="center">
						<td><input type="checkbox" value="<%=bean.getId()%>"
							name="ids"></td>

						<td><%=bean.getId()%></td>
						<td><%=bean.getFirstName()%></td>
						<td><%=bean.getLastName()%></td>
						<td><%=bean.getloginId()%></td>
						<td><%=bean.getDob()%></td>
						<td><a href="UserCtl?id=<%=bean.getId()%>">Edit</a></td>


					</tr>
					<%
						}
					%>
				</table>
				<br>
				<table>
					<tr>
						<input type="submit" value="delete" name="operation">

					</tr>

				</table>
		</center>
	</form>
</body>
</html>