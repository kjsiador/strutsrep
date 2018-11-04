<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.text{
width: 100%;
padding: 12px 20px;
margin: 8px 0;
display: inline-block;
border: 1px solid #ccc;
border-radius: 4px;
box-sizing: border-box;
}
.form{
margin: 0 auto; 
width:250px;
}
.submit{
width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>
<title>Login</title>
</head>
<body>
	<div style="color:red">
		<html:errors property="login"/>
	</div>
	<html:form action="/Login" styleClass="form">
		Username <html:text name="LoginForm" styleClass="text" property="username"/>
		Password <html:password name="LoginForm" styleClass="text" property="password"/>
		<html:submit value="Login" styleClass="submit"/>
	</html:form>
</body>
</html>