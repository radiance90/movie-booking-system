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

<c:choose>
<c:when test="${listsize == 0}">
<center>
<h1>No result found!</h1>

</center>
</c:when>
<c:otherwise>
<center>
<h1>Results</h1>

</center>
<c:forEach var="movie" items="${searchlist}" varStatus="loop">
	<h3>
	
	
	<a href="control?action=addone&pos=${loop.index }">${movie.title }</a>
	</h3>
</c:forEach>

</c:otherwise>
</c:choose>
<br><h3><a href="manager_search.jsp">Go back to search</a></h3>
</body>
</html>