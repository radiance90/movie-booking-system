<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Booking Record</title>
</head>
<body>
<center>
<h1>Booking Record</h1>
</center>


<c:choose>
<c:when test="${ordersize == 0}">

<center>
<h1>No booking record!</h1>
</center>
<center>
<h1><a href="user_home.jsp">Go to Home Page</a></h1>

</center>
</c:when>
<c:otherwise>
<c:forEach var="order" items="${orderlist}" varStatus="loop">
	
	Order ID: ${order.ID}<br>
	Movie: ${order.title}<br>
	Location: ${order.location}<br>
	Date: ${order.showingDate}<br>
	Time: ${order.showingTime}<br>
	Number of tickets: ${order.tickets}<br>
	<br>
</c:forEach>


<center>
<h1><a href="user_home.jsp">Go to Home Page</a></h1>
</center>
</c:otherwise>
</c:choose>
</body>
</html>