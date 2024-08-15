<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./crud_index1.jsp" %>
<title>Insert title here</title>
</head>
<body>
	<h1>This is main index</h1>
	
	<div class="container">
    	<form action="form_handler" method="post">
		  <div class="form-group">
		    <label for="name">Product name</label>
		    <input 
		    type="text" 
		    class="form-control" 
		    id="name" 
		    aria-describedby="emailHelp" 
		    placeholder="Enter Name of Product"
		    name = "name">
		  </div>
		  <div class="form-group">
		    <label for="description">Product description</label>
		    <textarea 
		    class="form-control" 
		    id="description"
		    rows="6"
		    name = "description"></textarea>
		  </div>
		  <div class="form-group">
		    <label for="price">Product price</label>
		    <input 
		    type="text" 
		    class="form-control" 
		    id="price" 
		    aria-describedby="emailHelp" 
		    placeholder="Enter Price of Product"
		    name = "price">
		  </div>
		  <div class = "container text-center">
			  <a href = "${pageContext.request.contextPath }/"
			  	 class = "btn btn-outline-danger">Back</a>
			  <button type="submit" class="btn btn-primary">Add</button>	 
		  </div>
		  
		</form>
    </div>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  
</body>
</html>