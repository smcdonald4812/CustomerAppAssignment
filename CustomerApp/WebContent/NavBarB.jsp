<%@page import="com.mcdonald.util.Deletes"%>
<%@page import="com.mcdonald.util.Updates"%>
<%@page import="com.mcdonald.util.Inserts"%>
<%@page import="com.mcdonald.util.Selects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">Customer App</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link text-secondary" href="indexB.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="productsB.jsp">Products</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="customersB.jsp">Customers</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="ordersB.jsp">Orders</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="index.jsp">Assignment</a></li>	
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>