<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home</title>
</head>
<body>
<center>
<h1>Home</h1>
<h1><a href="control?action=userprofile">My Profile</a></h1>
<h1><a href="control?action=userbookings">My Bookings</a></h1>
<form name="input" action="control" method="get">
Search: <input type="text" name="keywords"><br><br>


<input type="hidden" name="action" value="usersearch"/>
<input type="submit" value="Search">
</form>
</center>
</body>
</html>