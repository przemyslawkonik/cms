<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Articles</title>
</head>
<body>
 <h1>Articles</h1>
 <%@include file="/WEB-INF/views/header.jsp"%>
 <hr>
 
 <c:forEach var="a" items="${articles}">
  <table border="1">
   <tr>
    <th scope="col">Title</th>
    <th scope="col">Author</th>
    <th scope="col">Created</th>
    <th scope="col">Updated</th>
    <th colspan="2">Actions</th>
   </tr>
   <tr>
    <td>${a.title}</td>
    <td>${a.author.fullName}</td>
    <td>${a.created}</td>
    <td>${a.updated}</td>
    <td><a href="${pageContext.request.contextPath}/articles/edit/${a.id}">Edit</a></td>
    <td><a href="${pageContext.request.contextPath}/articles/delete/${a.id}">Delete</a></td>
   </tr>
  </table>
  <div>
   <span>Categories: </span>
   <c:forEach var="c" items="${a.categories}">
    <span>${c.name} </span>
   </c:forEach>
  </div><br>
  <p>${a.content}</p><hr>
 </c:forEach>
 <a href="${pageContext.request.contextPath}/articles/add">Add new article</a>
 
</body>
</html>