<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<form:form  action="/api/formParameters" method="POST" modelAttribute="Employee">
  <spring:message text="id"></spring:message>
  <form:input path="id"/>
  <br>
  <spring:message text="First Name"></spring:message>
  <form:input path="firstName"/>
  <br>
  <spring:message text="Last Name"></spring:message>
  <form:input path="lastName"/>
  <br>
  <spring:message text="salary"></spring:message>
  <form:input path="salary"/>
  <br>
  <form:button value="submit">submit</form:button>
</form:form>
</body>
</html>