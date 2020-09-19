<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm OTP</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
	<div class="row">	
	
		<div class="col-sm-0 col-xs-0 col-md-2 col-lg-4">
		</div>
	
		<div class="col-sm-12 col-xs-12 col-md-8 col-lg-4 rounded border border-secondary">
			<br>
			<div class="h3">OTP Confirmation</div>
			<br>
			<form action="OTPServlet" method="post">
				<input type="number" name="otpid" value="${param.otpid}" hidden="true"/>
				
				<div class="form-group">
					<label>OTP Code</label>
					<input class="form-control" type="text" name="otpcode" required="required" placeholer="Enter OTP Code Here"/>
					<br>
				</div>		
				<div class="form-group">
					<input class="form-control btn-primary" type="submit" name="confirm" value="Confirm"/></td>
				</div>
			</form>
		</div>
		
	</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>