<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Drafts</title>
</head>
<body>
 <h1>Drafts</h1>
 <%@include file="/WEB-INF/views/header.jsp"%>
 <hr>
 
 <c:forEach var="d" items="${drafts}">
  <table border="1">
   <tr>
    <th scope="col">Title</th>
    <th scope="col">Created</th>
    <th scope="col">Updated</th>
    <th colspan="2">Actions</th>
   </tr>
   <tr>
    <td>${d.title}</td>
    <td>${d.created}</td>
    <td>${d.updated}</td>
    <td><a href="${pageContext.request.contextPath}/drafts/edit/${d.id}">Edit</a></td>
    <td><a href="${pageContext.request.contextPath}/drafts/delete/${d.id}">Delete</a></td>
   </tr>
  </table>
  <p>${d.content}</p><hr>
 </c:forEach>
 <a href="${pageContext.request.contextPath}/drafts/add">Add new draft</a>
 
</body>
</html>