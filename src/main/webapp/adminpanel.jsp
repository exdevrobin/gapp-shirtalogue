<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Panel</title>
</head>
<style>
	.option
	{
		background-color: #000;
		padding
	}
</style>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="centered col-xs-2 col-sm-2 col-md-2 col-lg-2">
		<a href="/productlist">
			<div class="option">
				Products
			</div>
		</a>
	</div>	
	
	<div class="centered col-xs-2 col-sm-2 col-md-2 col-lg-2">
		<a href="/productlist">
			<div class="option">
				
			</div>
		</a>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>