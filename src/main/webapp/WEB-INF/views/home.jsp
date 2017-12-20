<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
 <h1>Home page</h1><hr>
 
 <form method="post">
  <label for="selector">Categories</label>
  <select id="selector" name="categoryId">
   <c:forEach var="c" items="${categories}">
    <option value="${c.id}" label="${c.name}"/>
   </c:forEach>
  </select>
  <input type="submit" value="Go"/>
 </form><hr>
 
 <c:forEach var="a" items="${latestArticles}">
  <table border="1">
   <tr>
    <th scope="col">Title</th>
    <th scope="col">Created</th>
   </tr>
   <tr>
    <td>${a.title}</td>
    <td>${a.created}</td>
   </tr>
  </table>
  <p>${a.content}</p><hr>
 </c:forEach>
 
</body>
</html>