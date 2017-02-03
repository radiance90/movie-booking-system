<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Time</title>
</head>
<body>
<center>
<h1>Search for a Movie</h1>

<form name="input" action="control" method="get">
Search: <input type="text" name="keywords"><br><br>


<input type="hidden" name="action" value="manager_search"/>
<input type="submit" value="Search">
<a href="manager_home.jsp">Cancel</a>
</form>
</center>
</body>
</html>