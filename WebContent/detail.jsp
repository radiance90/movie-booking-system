<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Details</title>
</head>
<body>
<center>
<h1>Details</h1>
</center>
<c:choose>
<c:when test="${released == true}">

<h3>${movie.title}</h3>
	<img src="image/${movie.poster }.jpg" width="400" height="600"/><br>
	Staring: ${movie.actors}<br>
	Synopsis: ${movie.synopsis}<br>
	Staring: ${movie.actors}<br>
	Age Rating: ${movie.AGEOFRATING}<br>
	Director: ${movie.director}<br>
	Genre: ${movie.genre}<br>
	Release Date: ${movie.relaseDate}<br>
	Rating: ${movie.rating}<br>
	
<h3>Now playing at: </h3>
<c:choose>
<c:when test="${cinemassize == 0}">
<h4>No cinema!</h4>
</c:when>
<c:otherwise>
<c:forEach items="${cinemas}" var="cinema"> 
${cinema}
</c:forEach>
</c:otherwise>
</c:choose>

<h3>Comments</h3>
<c:choose>
<c:when test="${commentsize == 0}">
<h4>No comments yet!</h4>
</c:when>
<c:otherwise>

<table> 
<tr>
<th>Rating</th><th>Comment</th><th> On </th><th> By </th></tr>
<c:forEach items="${commentlist}" var="comment"> 
<tr>
<td>${comment.RATING}</td><td>${comment.reviews}</td><td>${comment.COMDATE} ${comment.COMtime }</td>
<td>${comment.NICKNAME}</td>
</tr>
</c:forEach> </table>
</c:otherwise>
</c:choose>

<form name="input" action="control" method="post">
Add a Rating: <br>
<input type="radio" name="newrating" value="1">1<br>
<input type="radio" name="newrating" value="2">2<br>
<input type="radio" name="newrating" value="3" checked = "checked">3<br>
<input type="radio" name="newrating" value="4">4<br>
<input type="radio" name="newrating" value="5">5<br>
Add a New Comment: <input type="text" name="newcomment" style="width: 200px;"value = "add a new comment."><br>


<input type="hidden" name="action" value="addcomment"/>
<input type="submit" value="Add">
</form>

<form name="input" action="control" method="get">
<br>

Select a cinema you want to check:<br>
<select name="cinema">
<c:forEach var="place" items="${cinemas}" varStatus="loop">
<option value="${place }">${place }</option>
</c:forEach>
</select>
<br>
Select a date(YYYY-MM-DD): <input type="text" name="date"><br>
<input type="hidden" name="action" value="findtime"/>
<input type="submit" value="Search">
</form>

</c:when>
<c:otherwise>

<h3>${movie.title}</h3>
	<img src="image/${movie.poster }.jpg" width="400" height="600"/><br>
	Staring: ${movie.actors}<br>
	Synopsis: ${movie.synopsis}<br>
	Staring: ${movie.actors}<br>
	Age Rating: ${movie.AGEOFRATING}<br>
	Director: ${movie.director}<br>
	Genre: ${movie.genre}<br>
	Release Date: ${movie.relaseDate}<br>
	

</c:otherwise>
</c:choose>

<h1><a href="user_result.jsp">Go back to results</a></h1>
</body>
</html>