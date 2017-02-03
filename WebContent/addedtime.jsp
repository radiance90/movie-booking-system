<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add time</title>
</head>
<body>
<c:choose>
<c:when test="${timeadded == true }">
<h1>Congratulations! Time is added!</h1>
<a href="manager_home.jsp">Back</a>
</c:when>

<c:when test="${empty_in == true }">
<h1>Inputs cannot be empty!</h1>
<a href="addtime.jsp">Back</a>
</c:when>


<c:when test="${invalid_newdate == true }">
<h1>Invalid Date!</h1>
<a href="addtime.jsp">Back</a>
</c:when>
<c:otherwise>
<h1>Time exists!</h1>

<a href="addtime.jsp">Back</a>
</c:otherwise>


</c:choose>
</body>
</html>