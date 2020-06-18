<%@page import="java.util.Iterator"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="com.mcdonald.cls.Product"%>
<%@page import="com.mcdonald.cls.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.mcdonald.util.Retrieve"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers and Products</title>
</head>
<%! Retrieve get;%>
<body>
<jsp:include page="navbar.jsp" flush="true" />
<div class="container mx-auto" style="padding-top:75px">
<%
get = new Retrieve();
Map<Customer,List<Product>> map = get.getCustomerAndProduct();
Iterator<Customer> e = map.keySet().iterator();
while(e.hasNext()) {
	Customer c = (Customer)e.next();
	if(!map.get(c).isEmpty()) {
	%>
	<table class="table table-borderless table-dark">
	<tr><td>CUSTOMER ID: <%=c.getId() %></td><td>Customer Name: <%=c.getFirst() %> <%=c.getLast() %></td></tr>
	<%
	List<Product> ls = map.get(c);
	for(Product p:ls) {
		%>
		<tr><td>PRODUCT ID:</td><td><%=p.getId() %></td></tr>
		<tr><td>PRODUCT NAME:</td><td><%=p.getName() %></td></tr>
		<tr><td>PRODUCT COST::</td><td>$<%=p.getPrice() %></td></tr>
		<tr><td>PRODUCT STOCK:</td><td><%=p.getStock() %></td></tr>
		<%
	}
	%>
	<tr><td><form method="post" action="./DeleteServe"><input type=hidden name="id" value="<%=c.getId()%>"><input class="btn btn-danger" type="submit" value="Submit"></form></td><td>Deletes this customers orders!</td></tr>
	<%
	}
}
%>
</table>
</div>
</body>
</html>