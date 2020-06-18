<%@page import="java.util.List"%>
<%@page import="com.mcdonald.cls.Customer"%>
<%@page import="com.mcdonald.util.Retrieve"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<%! Retrieve get;%>
<body>
<jsp:include page="navbar.jsp" flush="true" />
<div class="container mx-auto" style="padding-top:75px">
<table class="table table-borderless table-dark">
<thead><tr><th>ID</th><th>First Name</th><th>Last Name</th>
		<th>Address</th><th>City</th><th>State</th>
		<th>Zip</th><th>Country</th></tr></thead>
<%
get = new Retrieve();
List<Customer> list = get.getAllCustomers();
for(Customer c : list) {
	%>
		
		<tr><td><%=c.getId()%></td><td><%=c.getFirst() %></td><td><%=c.getLast() %></td>
		<td><%=c.getAddress() %></td><td><%=c.getCity() %></td><td><%=c.getState() %></td>
		<td><%=c.getZip() %></td><td><%=c.getCountry() %></td></tr>
	<%	
}
%>
</table>
</div>
</body>
</html>