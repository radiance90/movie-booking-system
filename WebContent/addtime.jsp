<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Time</title>
</head>
<body>
<center>
<h1>Add Time</h1>
</center>
<form name="input" action="control" method="post">
Date: <input type="text" name="selecteddate"><br><br>
<select name="selectedtime">

<option value="08:00">08:00</option>
<option value="10:00">08:00</option>
<option value="12:00">08:00</option>
<option value="14:00">08:00</option>
<option value="16:00">08:00</option>
<option value="18:00">08:00</option>
<option value="20:00">08:00</option>
<option value="22:00">08:00</option>
<option value="24:00">08:00</option>
</select>

<select name="selectedcinema">
<c:forEach var="cinema" items="${cinemalist}" varStatus="loop">
<option value="${cinema.location}">${cinema.location}</option>
</c:forEach>
</select>
			
<input type="hidden" name="action" value="addtime"/>
<input type="submit" value="Save">
<a href="manager_result.jsp">Cancel</a>
</form><br>

</body>
</html>