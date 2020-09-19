<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
	<div class="row">	
	
		<div class="col-sm-0 col-xs-0 col-md-2 col-lg-4">
		</div>
	
		<div class="col-sm-12 col-xs-12 col-md-8 col-lg-4 rounded border border-secondary">
			<br>
			<div class="h3">Create Account</div>
			<br>
			
			<form action="RegistrationServlet" method="post">
		
				<input  class="form-control" type="number" name="userid" hidden="true"/>
				
				<div class="form-group">
				<label>Full Name</label><br>
				<input  class="form-control" type="text" name="username" required="required" placeholder="eg: Joe Smith"/>
				</div>
				
				<div class="form-group">
				<label>Gender</label><br>
				<select  class="form-control" name="usergender" Size="1">  
					<option value="male" selected="selected"> Male </option>
					<option value="female"> Female </option> 
				</select>
				</div>
				
				<div class="form-group">
				<label>Email</label><br>
				<input  class="form-control" type="email" name="useremail" required="required"  placeholder="eg: jay.smith@domain.com"/>
				</div>
				
				<div class="form-group">
				<label>Password</label><br>
				<input  class="form-control" type="password" name="userpassword" required="required"/>
				</div>
				
				<div class="form-group">
				<input type="checkbox" id="termsmconditions" name="terms"/> <a href="terms.jsp" target="_blank">I agree to the Terms and Conditions</a>
				</div><br>
				
				<div class="form-group">
					<input  class="form-control btn-danger" type="reset" name="reset" value="Clear"/><br>
					<input  class="form-control btn-primary" id="submitbutton" type="submit" name="register" value="Sign Up" disabled="disabled"/><br>
				</div>
			</form>
			
			<a href="login.jsp" style="text-align: center"> I already have an account</a><br><br>
			
		</div>
	</div>
	</div>
	<br>
	<br>
			
	<jsp:include page="footer.jsp"/>
	
	<script type="text/javascript">
		var termscheckbox = document.getElementById('termsmconditions');
		var submitbtn = document.getElementById('submitbutton');
		termscheckbox.onchange = function() {
	  		submitbtn.disabled = !this.checked;
		};
	</script>
</body>
</html>