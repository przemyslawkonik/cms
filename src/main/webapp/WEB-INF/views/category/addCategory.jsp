<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/edit category</title>
</head>
<body>
 <h1>Add/Edit category</h1>
 <%@include file="/WEB-INF/views/header.jsp"%>
 <hr>
 
 <form:form method="post" modelAttribute="category">
  <form:input path="name" placeholder="Name"/><form:errors path="name"/><br>
  <form:textarea path="description" placeholder="Description..."/><br>
  <input type="submit"/>
 </form:form>

</body>
</html>