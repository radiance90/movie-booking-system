<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register</title>
</head>
<body>


<c:choose>
<c:when test="${registered == true}">

<center>
<h1>Register Complete!</h1>
</center>
<center>
<h2>A confirmation email has been sent to your email</h2>
<h1><a href="index.jsp">Back to Home Page</a></h1>
</center>
</c:when>
<c:otherwise>

<center>
<h1>Register Fail!</h1>
</center>
<c:if test="${duplicate_name == true} ">
<h2>The user name has been used</h2>
</c:if>
<c:if test="${wrong_name == true }">
<h2>User name consists of letters, numbers and "_" only</h2>
</c:if>
<c:if test="${empty_pass == true }">
<h2>password cannot be empty</h2>
</c:if>
<c:if test="${empty_email == true }">
<h2>invalid email</h2>
</c:if>
<h2>Please try again!</h2>

<center>
<h1><a href="register.jsp">Go back to Register</a></h1>
</center>
</c:otherwise>
</c:choose>


</body>
</html>