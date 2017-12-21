<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories</title>
</head>
<body>
 <h1>Categories</h1>
 <%@include file="/WEB-INF/views/header.jsp"%>
 <hr>
 
 <table border="1">
  <tr>
   <th scope="col">Name</th>
   <th scope="col">Description</th>
   <th colspan="2">Actions</th>
  </tr>
  <c:forEach var="c" items="${categories}">
   <tr>
    <td>${c.name}</td>
    <td>${c.description}</td>
    <td><a href="${pageContext.request.contextPath}/categories/edit/${c.id}">Edit</a></td>
    <td><a href="${pageContext.request.contextPath}/categories/delete/${c.id}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
 <a href="${pageContext.request.contextPath}/categories/add">Add new category</a>
 
</body>
</html>