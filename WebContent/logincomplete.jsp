<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login</title>
</head>
<body>


<c:choose>

<c:when test="${user_login == true}">
<center>
<h1>Login Complete!</h1>
</center>
<center>
<h1><a href="user_home.jsp">Go to Home Page</a></h1>
</center>
</c:when>

<c:when test="${manager_login == true}">
<center>
<h1>Login Complete!</h1>
</center>
<center>
<h1><a href="manager_home.jsp">Go to Home Page</a></h1>
</center>
</c:when>

<c:when test="${notconfirm == true}">
<center>
<h1>Login Fail!</h1>
<h2>Account not activated yet!</h2>
</center>
<center>
<h1><a href="login.jsp">Go back to Login</a></h1>
</center>
</c:when>

<c:otherwise>

<center>
<h1>Login Fail!</h1>
</center>
<c:if test="${notexist_name == true }">
<h2>The user name does not exist!</h2>
</c:if>
<c:if test="${wrong_name == true }">
<h2>The user name does not exist!</h2>
</c:if>
<c:if test="${wrong_pass == true }">
<h2>Wrong password!</h2>
</c:if>
<c:if test="${empty_pass == true }">
<h2>Password cannot be empty!</h2>
</c:if>
<h2>Please try again!</h2>
<center>
<h1><a href="login.jsp">Go back to Login</a></h1>
</center>
</c:otherwise>
</c:choose>
</body>
</html>