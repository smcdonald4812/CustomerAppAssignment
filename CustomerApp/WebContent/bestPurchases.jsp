<%@page import="java.util.List"%>
<%@page import="com.mcdonald.util.Retrieve"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Best Purchases</title>
</head>
<%! Retrieve get;%>
<body>
<jsp:include page="navbar.jsp" flush="true" />
<div class="container mx-auto" style="padding-top:75px">
<table class="table table-borderless table-dark">
<%
get = new Retrieve();
List<List<Object>> list = get.getMostExpensivePurchase();
for(List<Object> l : list) {
	%><tr><%
	for(Object o : l) {%><td><%=o %></td><%;}
	%></tr><%	
}
%>
</table>
</div>
</body>
</html>