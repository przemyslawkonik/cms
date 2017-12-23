<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/edit author</title>
</head>
<body>
 <h1>Add/Edit author</h1>
 <%@include file="/WEB-INF/views/header.jsp"%>
 <hr>
 
 <form:form method="post" modelAttribute="author">
  <form:input path="firstName" placeholder="First name"/><form:errors path="firstName"/><br>
  <form:input path="lastName" placeholder="Last name"/><form:errors path="lastName"/><br>
  <input type="submit"/>
 </form:form>

</body>
</html>