<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Movie Booking System</title>
</head>
<body>
<h1>Welcome!</h1>
<center>
<h1><a href="login.jsp">login</a></h1>

<h1><a href="register.jsp">register</a></h1>
</center>

<h2>NOW SHOWING</h2>
<c:forEach var="movie" items="${showing}" varStatus="loop">
	<h3>${movie.title}</h3>
	<img src="image/${movie.poster }.jpg" width="200" height="400"/><br>
	Staring: ${movie.actors}<br>
	Synopsis: ${movie.synopsis}<br>
	Rating: ${movie.rating}<br>
			
</c:forEach>

<br><h2>COMING SOON</h2>
<c:forEach var="movie" items="${coming}" varStatus="loop">
	<h3>${movie.title}</h3>
	<img src="image/${movie.poster }.jpg" width="200" height="400"/><br>
	Staring: ${movie.actors}<br>
	Synopsis: ${movie.synopsis}<br>
	Release Date: ${movie.relaseDate}<br>
			
</c:forEach>



</body>
</html>