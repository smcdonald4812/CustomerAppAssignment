<%@page import="com.mcdonald.cls.Product"%>
<%@page import="com.mcdonald.cls.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.mcdonald.cls.Order"%>
<%@page import="com.mcdonald.util.Retrieve"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<%! Retrieve get;%>
<body>
<jsp:include page="navbar.jsp" flush="true" />
<div class="container mx-auto" style="padding-top:75px">
<table class="table table-borderless table-dark">
<%
get = new Retrieve();
List<Order> list = get.getAllOrders();
for(Order o : list) {
	Customer c = get.getCustomer(o.getCustomerId());
	Product p = get.getProduct(o.getProductId());
	%>
		<tr><td></td><td></td></tr>
		<tr><td>Order ID: <%=o.getId() %></td><td>Customer: <%=c.getFirst()%> <%=c.getLast()%></td><td>Product: <%=p.getName()%></td></tr>
		<tr><td></td><td></td></tr>
	<%	
}
%>
</table>
</div>
</body>
</html>