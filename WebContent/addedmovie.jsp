<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add movie</title>
</head>
<body>
<c:choose>
<c:when test="${movieadded == true }">
<h1>Congratulations! Movie is added!</h1>
<a href="manager_home.jsp">Back</a>
</c:when>

<c:when test="${empty_input == true }">
<h1>Inputs cannot be empty!</h1>
<a href="addmovie.jsp">Back</a>
</c:when>

<c:when test="${wrong_age == true }">
<h1>Invalid Age Rating!</h1>
<a href="addmovie.jsp">Back</a>
</c:when>

<c:when test="${invalid_release == true }">
<h1>Invalid Release Date!</h1>
<a href="addmovie.jsp">Back</a>
</c:when>
<c:otherwise>
<h1>Movie exists!</h1>

<a href="addmovie.jsp">Back</a>
</c:otherwise>


</c:choose>
</body>
</html>