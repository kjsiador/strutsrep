<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table {
    border-collapse: collapse;
    width: 50%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
<title>Users</title>
</head>
<body>
	<table>
		<tr>
			<th>User Id</th>
			<th>Username</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
		</tr>
		<logic:iterate name="userList" id="userListId">
			<tr>
				<td><bean:write name="userListId" property="userid" /></td>
				<td><bean:write name="userListId" property="username" /></td>
				<td><bean:write name="userListId" property="firstname" /></td>
				<td><bean:write name="userListId" property="lastname" /></td>
				<td><bean:write name="userListId" property="email" /></td>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>