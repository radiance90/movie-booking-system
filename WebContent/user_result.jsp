<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Result</title>
</head>
<body>
<center>
<h1>Results</h1>

</center>

<c:choose>
<c:when test="${listsize == 0}">
<center>
<h1>No result found!</h1>

</center>
</c:when>
<c:otherwise>
<c:forEach var="movie" items="${searchlist}" varStatus="loop">
	<h3>${movie.title}</h3>
	<img src="image/${movie.poster }.jpg" width="200" height="400"/><br>
	Staring: ${movie.actors}<br>
	Genre: ${movie.genre}<br>
	Rating: ${movie.rating}<br>
	
	<a href="control?action=detail&pos=${loop.index }">Detail</a>
</c:forEach>

</c:otherwise>
</c:choose>
<h1><a href="user_home.jsp">Go back to search</a></h1>
</body>
</html>