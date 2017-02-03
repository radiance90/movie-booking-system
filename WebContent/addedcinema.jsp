<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Cinema</title>
</head>
<body>
<c:choose>
<c:when test="${addedcinema == true }">
<h1>Congratulations! Cinema is added!</h1>
<a href="manager_home.jsp">Back</a>
</c:when>

<c:when test="${empty_loc == true }">
<h1>Location cannot be empty!</h1>
<a href="addcinema.jsp">Back</a>
</c:when>

<c:when test="${wrong_seat == true }">
<h1>Seat capacity must be a positive integer!</h1>
<a href="addcinema.jsp">Back</a>
</c:when>

<c:otherwise>
<h1>Cinema exists!</h1>

<a href="addcinema.jsp">Back</a>
</c:otherwise>


</c:choose>
</body>
</html>