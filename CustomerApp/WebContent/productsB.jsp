<%@page import="com.mcdonald.util.Selects"%>
<%@page import="java.util.List"%>
<%@page import="com.mcdonald.cls.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<%!Selects select = new Selects();%>
<body>
<jsp:include page="NavBarB.jsp" flush="true" />
<div class="container mx-auto" style="padding-top:75px">
<%
List<Product> list = select.getProducts();
for(Product p : list) {
	%>
		<form method="POST" action="./ProdServe">
		<table class="table table-borderless table-light">
		<% if(p.getId()==1) {%>
		<thead><tr><th>ID</th><th>Name</th><th>Cost</th>
		<th>Stock</th></tr></thead>
		<%}%>
		<tr><td><%=p.getId()%></td>
		<td><input type="hidden" name="id" value="<%=p.getId()%>"><input type="text" name="name" value="<%=p.getName() %>" pattern="[A-Z a-z]+" required></td>
		<td><input type="text" name="cost" value="<%=p.getPrice() %>" pattern="[0-9]+.[0-9]+" required></td>
		<td><input type="text" name="stock" value="<%=p.getStock() %>" pattern="[0-9]+" required></td>
		<td><input class="btn btn-info" name="update" type="submit" value="Update"></td>
		<td><input class="btn btn-danger" name="delete" type="submit" value="Delete"></td></tr>
		</table>
		</form>
	<%	
}
%>
		<form method="POST" action="./ProdServe">
		<table class="table table-borderless table-light">
		<tr><td></td>
		<td><input type="text" name="name" placeholder="product name" pattern="[A-Z a-z]+" required></td>
		<td><input type="text" name="cost" placeholder="1.23" pattern="[0-9]+.[0-9]+" required></td>
		<td><input type="text" name="stock" placeholder="100" pattern="[0-9]+" required></td>
		<td><input class="btn btn-warning" name="insert" type="submit" value="Add"></td>
</table>
</form>
</div>
</body>
</html>