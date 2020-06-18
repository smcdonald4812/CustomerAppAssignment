<%@page import="java.util.List"%>
<%@page import="com.mcdonald.cls.Product"%>
<%@page import="com.mcdonald.util.Retrieve"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<%! Retrieve get;%>
<body>
<jsp:include page="navbar.jsp" flush="true" />
<div class="container mx-auto" style="padding-top:75px">
<%
get = new Retrieve();
List<Product> list = get.getAllProducts();
for(Product p : list) {
	%>
		<form method="post" action="./StockServe">
		<table class="table table-borderless table-dark">
		<thead><tr><th>ID</th><th>Name</th><th>Price</th><th>Stock</th></tr></thead>
		<tr><td><%=p.getId() %></td><td><%=p.getName()%></td>
		<td><%=p.getPrice() %></td><td><input type="text" name="stock" value="<%=p.getStock() %>"></td></tr>
		<tr><td><input type=hidden name="id" value="<%=p.getId()%>">This will update products.</td>
		<td></td><td></td><td><input class="btn btn-danger" type="submit" value="Submit"></td></tr>
		</table>
		</form>
	<%	
}
%>
</div>
</body>
</html>