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
  </tr>
  <c:forEach var="c" items="${categories}">
   <tr>
    <td>${c.name}</td>
    <td>${c.description}</td>
   </tr>
  </c:forEach>
 </table>
</body>
</html>