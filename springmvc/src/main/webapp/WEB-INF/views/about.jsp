<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
  <%@page isELIgnored="false"%>
<%--     <%@page import = "java.util.*"%> --%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Bootstrap demo</title>
    <link href="<c:url value="/resources/css/style.css"/> ">
    
    
<%--     <script src="<c:url value="/resources/js/script.js"/> " > </script> --%>
    
    
    </head>
  <body>
  <img src="<c:url value="/resources/image/akkuB.jpg" />" alt="Girl in a jacket" width="500" height="300">
  <h1>${heading}</h1>
  <p>${desc}</p>
  
   <div class="container mt-3">
    <form class="form-horizontal" action="processform" method="post">
    <div class="form-group">
	    <label class="control-label col-sm-2" for="name">Name</label>
	    <div class="col-sm-10">
	      <input type="text" name="name" class="form-control" id="name" placeholder="Enter name">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="email" >Email:</label>
	    <div class="col-sm-10">
	      <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="pwd">Password:</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" name="password" id="pwd" placeholder="Enter password">
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <div class="checkbox">
	        <label><input type="checkbox"> Remember me</label>
	      </div>
	    </div>
	  </div>
	  <div class="form-group mt-0">
	    <div class="col-sm-offset-2 col-sm-10 h-100 d-flex align-items-center justify-content-center">
	      <button type="submit" class="btn btn-success">Submit</button>
	    </div>
	  </div>
	</form>
	</div>
   
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>