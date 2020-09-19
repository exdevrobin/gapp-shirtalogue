<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<c:if test="${requestScope.product.productid==0}">
		<h4>Add Product</h4>
		
		<form action="AddProductServlet" method="post">
			<table>
				<tr>
				<td>Name</td>
				<td><input type="text" name="productname" value="${requestScope.product.productname}" required="required"/></td>
				</tr>		
				
				<tr>
				<td>Brand</td>
				<td><input type="text" name="productbrand"  value="${requestScope.product.productbrand}"/></td>
				</tr>	
				
				<tr>
				<td>Description</td>
				<td><textarea name="productdesc" rows="5">${requestScope.product.productdesc}</textarea></td>
				</tr>						

				<tr>
				<td>Fit</td>				
				<td>
				<select Name="productfit"  id="listBoxFit" Size="1">  
				<option value="Regular"> Regular Fit </option>
				<option value="Slim"> Slim Fit </option>
				</select>  
				</td>
				</tr>	
				
				<tr>
				<td>Color</td>		
				<td>
				<select Name="productcolor"  id="listBoxColor" Size="1">  
				<option value="NA"> Not Applicable </option>
				<option value="Multi Color"> Multi Color </option> 
				<option value="Black"> Black </option>  
				<option value="White"> White </option>  
				<option value="Red"> Red </option>  
				<option value="Blue"> Blue </option>  
				<option value="Green"> Green </option>  
				<option value="Yellow"> Yellow </option>  
				<option value="Brown"> Brown </option>  
				<option value="Orange"> Orange </option>  
				<option value="Teal"> Teal </option>  
				<option value="Tan"> Tan </option>  
				</select>  
				</td>
				</tr>	
				
				<tr><td><br></td></tr>
				
				<tr>
				<b>
				<td>Size</td>
				<td>Stock</td>
				<td>Price</td>
				</b>
				</tr>
				
				<tr>
				<td>Xtra Small</td>
				<td><input type="number" name="stock_xs" value="${requestScope.product.stock_xs}"/></td>
				<td><input type="number" name="price_xs" step="0.01" value="${requestScope.product.price_xs}"/> INR</td>
				</tr>	
				
				<tr>
				<td>Small</td>
				<td><input type="number" name="stock_s" value="${requestScope.product.stock_s}"/></td>
				<td><input type="number" name="price_s" step="0.01" value="${requestScope.product.price_s}"/> INR</td>
				</tr>	

				<tr>
				<td>Medium</td>
				<td><input type="number" name="stock_m" value="${requestScope.product.stock_m}"/></td>
				<td><input type="number" name="price_m" step="0.01" value="${requestScope.product.price_m}"/> INR</td>
				</tr>	
				
				<tr>
				<td>Large</td>
				<td><input type="number" name="stock_l" value="${requestScope.product.stock_l}"/></td>
				<td><input type="number" name="price_l" step="0.01" value="${requestScope.product.price_l}"/> INR</td>
				</tr>	
				
				<tr>
				<td>Xtra Large</td>
				<td><input type="number" name="stock_xl" value="${requestScope.product.stock_xl}"/></td>
				<td><input type="number" name="price_xl" step="0.01" value="${requestScope.product.price_xl}"/> INR</td>
				</tr>	
				
				<tr>
				<td>2 Xtra Large</td>
				<td><input type="number" name="stock_2xl" value="${requestScope.product.stock_2xl}"/></td>
				<td><input type="number" name="price_2xl" step="0.01" value="${requestScope.product.price_2xl}"/> INR</td>
				</tr>	
				
				<tr>
				<td><input type="reset" name="Clear"/></td>
				<td><input type="submit" name="Add"/></td>
				</tr>	
			</table>
		</form>
	</c:if>
	
	<c:if test="${requestScope.product.productid!=0}">
		<h4>Edit Product</h4>

		<form action="UpdateProductServlet" method="post">
			<table>
				<input type="number" name="productid" value="${requestScope.product.productid}" hidden="true"/>
				
				<tr>
				<td>Name</td>
				<td><input type="text" name="productname" value="${requestScope.product.productname}" readonly="readonly"/></td>
				</tr>		
				
				<tr>
				<td>Brand</td>
				<td><input type="text" name="productbrand"  value="${requestScope.product.productbrand}"/></td>
				</tr>	
				
				<tr>
				<td>Description</td>
				<td><textarea name="productdesc" rows="5">${requestScope.product.productdesc}</textarea></td>
				</tr>						

				<tr>
				<td>Fit</td>				
				<td>
				<select Name="productfit"  id="listBoxFit" Size="1">  
				<option value="Regular"> Regular Fit </option>
				<option value="Slim"> Slim Fit </option>
				</select>  
				</td>
				</tr>	
				
				<tr>
				<td>Color</td>		
				<td>
				<select Name="productcolor" id="listBoxColor" Size="1"  value="${requestScope.product.productcolor}">  
				<option value="NA"> Not Applicable </option>
				<option value="Multi Color"> Multi Color </option> 
				<option value="Black"> Black </option>  
				<option value="White"> White </option>  
				<option value="Red"> Red </option>  
				<option value="Blue"> Blue </option>  
				<option value="Green"> Green </option>  
				<option value="Yellow"> Yellow </option>  
				<option value="Brown"> Brown </option>  
				<option value="Orange"> Orange </option>  
				<option value="Teal"> Teal </option>  
				<option value="Tan"> Tan </option>  
				</select>  
				</td>
				</tr>	
				
				<tr><td><br></td></tr>
				
				<tr>
				<b>
				<td>Size</td>
				<td>Stock</td>
				<td>Price</td>
				</b>
				</tr>
				
				<tr>
				<td>Xtra Small</td>
				<td><input type="number" name="stock_xs" value="${requestScope.product.stock_xs}"/></td>
				<td><input type="number" name="price_xs" step="0.01" value="${requestScope.product.price_xs}"/> INR</td>
				</tr>	
				
				<tr>
				<td>Small</td>
				<td><input type="number" name="stock_s" value="${requestScope.product.stock_s}"/></td>
				<td><input type="number" name="price_s" step="0.01" value="${requestScope.product.price_s}"/> INR</td>
				</tr>	

				<tr>
				<td>Medium</td>
				<td><input type="number" name="stock_m" value="${requestScope.product.stock_m}"/></td>
				<td><input type="number" name="price_m" step="0.01" value="${requestScope.product.price_m}"/> INR</td>
				</tr>	
				
				<tr>
				<td>Large</td>
				<td><input type="number" name="stock_l" value="${requestScope.product.stock_l}"/></td>
				<td><input type="number" name="price_l" step="0.01" value="${requestScope.product.price_l}"/> INR</td>
				</tr>	
				
				<tr>
				<td>Xtra Large</td>
				<td><input type="number" name="stock_xl" value="${requestScope.product.stock_xl}"/></td>
				<td><input type="number" name="price_xl" step="0.01" value="${requestScope.product.price_xl}"/> INR</td>
				</tr>	
				
				<tr>
				<td>2 Xtra Large</td>
				<td><input type="number" name="stock_2xl" value="${requestScope.product.stock_2xl}"/></td>
				<td><input type="number" name="price_2xl" step="0.01" value="${requestScope.product.price_2xl}"/> INR</td>
				</tr>	
				
				<tr>
				<td><input type="reset" name="Clear"/></td>
				<td><input type="submit" name="Update"/></td>
				</tr>	
			</table>
		</form>
	</c:if>
	
	<c:if test="${requestScope.formerror!=''}">
	<h5>Errors:</h5>
	<div>${requestScope.formerror}</div>
	</c:if>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script>
	document.getElementById('listBoxFit').value="${requestScope.product.productfit}";
	document.getElementById('listBoxColor').value="${requestScope.product.productcolor}";
</script>
</html>