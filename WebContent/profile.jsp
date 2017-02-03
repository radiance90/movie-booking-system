<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Profile</title>
</head>
<body>
<center>
<h1>Profile</h1>
</center>
<form name="input" action="control" method="post">
User Name:      ${user.ACCOUNTNAME }<br><br>
Nickname:       <input type="text" name="nickname" value = ${user.NICKNAME }><br><br>
First Name:       <input type="text" name="firstname" value = ${user.FIRSTNAME }><br><br>
Last Name:       <input type="text" name="lastname" value = ${user.LASTNAME }><br><br>
E-mail Address: <input type="text" name="email" value = ${user.EMAIL }><br><br>


<input type="hidden" name="action" value="updateprofile"/>

<input type="submit" value="Update">
<c:choose>
<c:when test="${user.status == 'yes'}">

<a href="user_home.jsp">Cancel</a>
</c:when>
<c:otherwise>
<a href="welcome.jsp">Cancel</a>
</c:otherwise>

</c:choose>

</form><br>

</body>
</html>