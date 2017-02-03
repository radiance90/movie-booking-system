<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register</title>
</head>
<body>
<center>
<h1>Register</h1>
</center>
<form name="input" action="control" method="post">
User Name(letter,number and "_" only):      <input type="text" name="user_name"><br><br>
Password:       <input type="password" name="password"><br><br>
E-mail Address: <input type="text" name="email"><br><br>
<input type="hidden" name="action" value="register"/>

<input type="submit" value="Register">
<a href="index.jsp">Cancel</a>
</form><br>


</body>
</html>