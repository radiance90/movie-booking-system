<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Booking</title>
</head>
<body>


<c:choose>
<c:when test="${bookavail == true}">

<center>
<h1>Booking Available!</h1>
</center>
<center>
<h1><a href="checkout.jsp">Go Checkout</a></h1>
<h1><a href="booking.jsp">Cancel</a></h1>
</center>
</c:when>
<c:when test="${notint == true}">

<center>
<h1>Ticket number must be a positive integer!</h1>
</center>

<center>
<h1><a href="booking.jsp">Back</a></h1>
</center>
</c:when>
<c:when test="${negative == true}">

<center>
<h1>Ticket number must be a positive integer!</h1>
</center>

<center>
<h1><a href="booking.jsp">Back</a></h1>
</center>
</c:when>


<c:otherwise>

<center>
<h1>Not enough tickets left!</h1>
</center>

<center>
<h1><a href="booking.jsp">Back</a></h1>
</center>
</c:otherwise>
</c:choose>
</body>
</html>