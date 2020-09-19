<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
	<div class="row">	
	
		<div class="col-sm-0 col-xs-0 col-md-0 col-lg-4">
		</div>
	
		<div class="col-sm-12 col-xs-12 col-md-12 col-lg-4 rounded border border-secondary">
			<br>
			
			<div class="h3">Login</div>
			
			<br>
		
			<form action="LoginServlet" method="post">			
		  		<div class="form-group">
					<label>Email</label><br>
					<input class="form-control" type="email" name="email" required="required" placeholder="Enter Email"/>
				</div>
					
		 		<div class="form-group">
					<label>Password</label><br>
					<input class="form-control" type="password" name="password" required="required" placeholder="Enter Password"/>
				</div>
		
		 		<div class="checkbox">
		 			<label>
						<input name="rememberme" type="checkbox" value="">  Remember me 
					</label>
				</div>			
				
				<br>
				
				<div class="form-group">
					<input class="form-control btn-primary" type="submit" name="login" value="Login"/>
				</div>
			</form>
			
			<br>		
			<a href="/register" style="text-align: center"> I don't have an account</a><br><br>
		</div>
		

		
	</div>
	</div>
</body>
</html>