<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
  	<style>
		#navigation{
		  overflow: visible;
		  position: fixed;
		  top: 0;
		  width: 100%;
		  z-index: 1;
		}
		
		#excite:hover{
			color:orange;
		}

		.sht-heading{
			color: #5A8EE3;
		}
	</style>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">	  	
  	</head>
  	
<body>
<div id="navigation">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="/home.jsp"><img src="/images/shirtalogue.png" height="30px"/></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	    
	      <c:if test="${logrole=='buyer'}">
		      <!-- Buyers -->
		      <li class="nav-item active">
		        <a id="excite" class="nav-link" href="browse.jsp"> Start Shopping!! <span class="sr-only">(current)</span></a>
		      </li>
	      </c:if>
	      
	      <c:if test="${logrole=='admin'}">
		      <!-- Administrator -->
		      <li class="nav-item active">
		        <a id="excite" class="nav-link" href="productlist.jsp"> Inventory <span class="sr-only">(current)</span></a>
		      </li>
	     </c:if>
	     
	    <c:if test="${logrole==null}">
		      <!-- Guest User -->
		      <li class="nav-item active">
		      	<a id="excite" class="nav-link" href="/register"> Register </a>
			  </li>
	          
	          <li class="nav-item active">
		      	<a id="excite" class="nav-link" href="/login.jsp"> Login </a>
			  </li>
		</c:if>

		  <!-- Dropdown -->
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:orange;">
	          <c:if test="${logname!=null}">
	          	<!-- Logged User -->
	          	${logname}
	          </c:if>
	          
	          <c:if test="${logname==null}">
	          	<!-- Guest User -->
	          	Guest
	          </c:if>
	        </a>
	        
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="about.jsp"> About Us </a>
	          <a class="dropdown-item" href="contacts.jsp"> Contact Us </a>
	          <a class="dropdown-item" href="fandq.jsp"> F&Q </a>
	          
	          <c:if test="${logid!=null}">
		        <div class="dropdown-divider"></div>
	          	<a class="dropdown-item" href="/logout"> Logout </a>
	          </c:if>
	        </div>
	      </li>
	    </ul>
	  </div>
	</nav>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
  
<br>
<br>
<br>
<br>

</body>
</html>