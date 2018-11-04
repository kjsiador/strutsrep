<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.text {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.form {
	margin: 0 auto;
	width: 250px;
}

.submit {
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
<title>Add Movie</title>
</head>
<body>
	<div style="color:green">
		<logic:messagesPresent message="true" >
   			<html:messages id="message" message="true" >
     			<bean:write name="message" /><br/>
   			</html:messages>
		</logic:messagesPresent>
	</div>
	
	<html:form action="/Save_Movie" styleClass="form">
		Movie Name <html:text name="MoviesForm" styleClass="text"
			property="moviename" />
		Genre <html:text name="MoviesForm" styleClass="text"
			property="genre" />
		<html:submit value="Save" styleClass="submit" />
	</html:form>
</body>
</html>