<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<jsp:include page="navbar.jsp" flush="true" />
<div class="container" style="padding-top:75px">
<h1 class="mx-auto">Customer App Assignment</h1>
<p class="mx-auto">This assignment is to make three tables; customers, orders, and products.</p>
<table class="table table-borderless mx-auto">
<tr><td>Get all customers and their products:</td><td><a href="custProducts.jsp"><button class="btn btn-info">Here</button></a></td></tr>
<tr><td>Update quantity for a particular product:</td><td><a href="products.jsp"><button class="btn btn-info">Here</button></a></td></tr>
<tr><td>Delete all orders placed for a product by a particular customer:</td><td><a href="custProducts.jsp"><button class="btn btn-info">Here</button></a></td></tr>
<tr><td>Print the most expensive product purchased by a customer:</td><td><a href="bestPurchases.jsp"><button class="btn btn-info">Here</button></a></td></tr>
</table>
</div>
</body>
</html>