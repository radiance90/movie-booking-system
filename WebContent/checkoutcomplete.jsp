<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Checkout</title>
</head>
<body>
<c:choose>
<c:when test="${invalidcard == true }">
<h1>Invalid card!</h1>
<a href="booking.jsp">Back</a>
</c:when>

<c:otherwise>
<h1>Booking Complete!</h1>

<a href="user_home.jsp">Back to home</a>
</c:otherwise>


</c:choose>

</body>
</html>