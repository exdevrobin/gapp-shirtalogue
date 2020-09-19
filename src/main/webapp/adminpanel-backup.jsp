<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Panel</title>

<style type="text/css">
	* {box-sizing: border-box}
	
	.tab {
	  float: left;
	  border: 1px solid #ccc;
	  background-color: #f1f1f1;
	  width: 20%;
	  height: 100%;
	  position: fixed;
	}
	
	.tab button {
	  display: block;
	  background-color: inherit;
	  color: black;
	  padding: 22px 16px;
	  width: 100%;
	  border: none;
	  outline: none;
	  text-align: left;
	  cursor: pointer;
	  transition: 0.3s;
	}
	
	.tab button:hover {
	  background-color: #C7DCFF;
	}
	
	.tab button.active {
	  background-color: #7298D4;
	  color:#fff;
	}
	
	.tabcontent {
	  float: right;
	  padding: 0px 12px;
	  width: 80%;
	}
</style>

</head>
<body>
<div>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'HotList')" id="defaultOpen">Hot List (${requestScope.requestcount})</button>
  <button class="tablinks" onclick="openCity(event, 'RequestRequests')">Return Request (${requestScope.requestcount})</button>
  <button class="tablinks" onclick="openCity(event, 'ProductList')">Products (${requestScope.productcount})</button>
  <button class="tablinks" onclick="openCity(event, 'OrderHistory')">History (${requestScope.usercount})</button>
</div>

<div id="HotList" class="tabcontent">
  <h3>Hot List</h3>
  <p>Paris is the capital of France.</p>
</div>

<div id="RequestRequests" class="tabcontent">
  <h3>Return Requests</h3>
  <p>Paris is the capital of France.</p>
</div>

<div id="ProductList" class="tabcontent">
  <h3>Product List</h3>
  <p>Paris is the capital of France.</p>
</div>

<div id="OrderHistory" class="tabcontent">
  <h3>Order History</h3>
  <br>
  <br>  <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
    <br>
  <br>
  
  <p>Tokyo is the capital of Japan.</p>
</div>

</div>

<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>

</body>
</html>