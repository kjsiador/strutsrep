<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<h1>
		Welcome to Struts1
		<bean:write name="LoginForm" property="username" />
	</h1>
	<ul>
		<li>Users
			<ul>
				<li><html:link forward="AddUser">Add Users</html:link></li>
				<li><html:link action="/View_User">View Users</html:link></li>
			</ul>
		</li>
		<li>Movies
		<ul>
			<li><html:link forward="AddMovies">Add Movies</html:link></li>
			<li><html:link action="/View_Movies">View Movies</html:link></li>
		</ul>
	</li>
	</ul>
</body>
</html>