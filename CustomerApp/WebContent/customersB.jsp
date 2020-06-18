<%@page import="com.mcdonald.util.Selects"%>
<%@page import="com.mcdonald.cls.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<%!Selects select = new Selects();%>
<body class="bg-light">
<jsp:include page="NavBarB.jsp" flush="true" />
<div class="container mx-auto" style="padding-top:75px">
<%
List<Customer> list = select.getCustomers();
for(Customer c : list) {
	%>
		<form method="POST" action="./CustServe">
		<table class="table table-borderless table-light">
		<% if(c.getId()==1) {%>
		<thead><tr><th>ID</th><th>First Name</th><th>Last Name</th>
		<th>Address</th><th>City</th><th>State</th>
		<th>Zip</th><th>Country</th><th></th><th></th></tr></thead>
		<%}%>
		<tr><td><%=c.getId()%></td>
		<td><input type="hidden" name="id" value="<%=c.getId()%>"><input type="text" name="first" value="<%=c.getFirst() %>" pattern="[A-Za-z]+" required></td>
		<td><input type="text" name="last" value="<%=c.getLast() %>" pattern="[A-Za-z]+" required></td>
		<td><input type="text" name="address" value="<%=c.getAddress() %>" pattern="[0-9]+ [A-Z -.,a-z0-9]+" required></td>
		<td><input type="text" name="city" value="<%=c.getCity() %>" pattern="[A-Z a-z]+" required></td>
		<td><input type="text" name="state" value="<%=c.getState() %>" pattern="[A-Z]{2}"></td>
		<td><input type="text" name="zip" value="<%=c.getZip() %>" pattern="[0-9]{5}"></td>
		<td><input type="text" name="first" value="<%=c.getCountry() %>" pattern="[A-Z]{3}" required></td>
		<td><input class="btn btn-info" name="update" type="submit" value="Update"></td>
		<td><input class="btn btn-danger" name="delete" type="submit" value="Delete"></td></tr>
		</table>
		</form>
	<%	
}
%>
		<form method="POST" action="./CustServe">
		<table class="table table-borderless table-light">
		<tr><td>N</td>
		<td><input type="text" name="first" placeholder="first name" pattern="[A-Za-z]+" required></td>
		<td><input type="text" name="last" placeholder="last name" pattern="[A-Za-z]+" required></td>
		<td><input type="text" name="address" placeholder="555 xyz st." pattern="[0-9]+ [A-Z .,a-z]+" required></td>
		<td><input type="text" name="city" placeholder="city" pattern="[A-Z a-z]+" required></td>
		<td><input type="text" name="state" placeholder="AA" pattern="[A-Z]{2}"></td>
		<td><input type="text" name="zip" placeholder="00000" pattern="[0-9]{5}"></td>
		<td><input type="text" name="country" placeholder="USA" pattern="[A-Z]{3}" required></td>
		<td><input class="btn btn-warning" name="insert" type="submit" value="Add"></td>
</table>
</form>
</div>
</body>
</html>