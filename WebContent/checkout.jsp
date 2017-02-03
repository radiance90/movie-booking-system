<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="control.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Checkout</title>
</head>
<body>
<Center>
<h1>Checkout</h1>
</Center>
<form name="input" action="control" method="post">
Name:      <input type="text" name="card_name"><br><br>
Card Number:       <input type="password" name="card_num"><br><br>

<input type="hidden" name="action" value="checkout"/>
<input type="submit" value="Confirm">
<a href="booking.jsp">Cancel</a>
</form><br>
</body>
</html>