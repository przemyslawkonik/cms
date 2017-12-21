<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authors</title>
</head>
<body>
 <h1>Authors</h1>
 <%@include file="/WEB-INF/views/header.jsp"%>
 <hr>
 
 <table border="1">
  <tr>
   <th scope="col">First name</th>
   <th scope="col">Last name</th>
   <th colspan="2">Actions</th>
  </tr>
  <c:forEach var="a" items="${authors}">
   <tr>
    <td>${a.firstName}</td>
    <td>${a.lastName}</td>
    <td><a href="${pageContext.request.contextPath}/authors/edit/${a.id}">Edit</a></td>
    <td><a href="${pageContext.request.contextPath}/authors/delete/${a.id}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
 <a href="${pageContext.request.contextPath}/authors/add">Add new author</a>
 
</body>
</html>