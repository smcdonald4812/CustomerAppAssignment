<%@page import="java.util.List"%>
<%@page import="com.mcdonald.cls.Order"%>
<%@page import="com.mcdonald.util.Selects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<%!Selects select = new Selects();%>
</head>
<body>
<jsp:include page="NavBarB.jsp" flush="true" />
<div class="container mx-auto" style="padding-top:75px">
<%
List<Order> list = select.getOrders();
for(Order o : list) {
	%>
		<form method="POST" action="./OrdServe">
		<table class="table table-borderless table-light">
		<% if(o.getId()==1) {%>
		<thead><tr><th>ID</th><th>Customer ID</th><th>Product ID</th>
		<th></th><th></th></tr></thead>
		<%}%>
		<tr><td><%=o.getId()%></td>
		<td><input type="hidden" name="id" value="<%=o.getId()%>"><input type="text" name="customer" value="<%=o.getCustomerId() %>" pattern="[0-9]+" required></td>
		<td><input type="text" name="product" value="<%=o.getProductId() %>" pattern="[0-9]+" required></td>
		<td><input class="btn btn-info" name="update" type="submit" value="Update"></td>
		<td><input class="btn btn-danger" name="delete" type="submit" value="Delete"></td></tr>
		</table>
		</form>
	<%	
}
%>
		<form method="POST" action="./OrdServe">
		<table class="table table-borderless table-light">
		<tr><td></td>
		<td><input type="text" name="customer" placeholder="product name" pattern="[0-9]+"required></td>
		<td><input type="text" name="product" placeholder="1.23" pattern="[0-9]+" required></td>
		<td></td>
		<td><input class="btn btn-warning" name="insert" type="submit" value="Add"></td>
</table>
</form>
</div>
</body>
</html>