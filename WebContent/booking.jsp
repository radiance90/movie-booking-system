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
<center>
<h1>Booking</h1>
</center>
<c:choose>
<c:when test="${empty_date == true}">
<center>
<h1>Date cannot be empty!</h1>
</center>
<center>
<h1><a href="detail.jsp">Back</a></h1>
</center>
</c:when>

<c:when test="${invalid_date == true}">
<center>
<h1>Date is not valid!</h1>
</center>
<center>
<h1><a href="detail.jsp">Back</a></h1>
</center>
</c:when>

<c:when test="${timesize == 0}">
<center>
<h1>No showing time available!</h1>
</center>
<center>
<h1><a href="detail.jsp">Back</a></h1>
</center>
</c:when>


<c:otherwise>

<form name="input" action="control" method="post">
<h2>Select a time</h2>
<select name="time">
<c:forEach var="show" items="${showlist}" varStatus="loop">
<option value="${loop.index }">${show.showing }</option>
</c:forEach>
</select>
Select Number of Tickets: <input type="text" name="ticket"><br>


<input type="hidden" name="action" value="booking"/>
<input type="submit" value="Check booking">
</form>

<h1><a href="detail.jsp">Back</a></h1>

</c:otherwise>
</c:choose>
</body>
</html>