<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
  
  <%@page isELIgnored="false"%>
    <%@page import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>India jeet gya!</title>
<link href="<c:url value = "/resources/css/style.css"/>">
<script src="<c:url value = "/resources/js/style.css"/>"></script> 
</head>
<body>
	<p> this is home page </p>
	<h1>MY name is ff ${name} </h1>
	<h1>List is as ${liist}</h1>		
	<hr>
	<c:forEach var="item" items="${liist}">
		<h1>$(item)</h1>
	</c:forEach>	
</body>
</html>