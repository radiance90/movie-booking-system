<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Cinema</title>
</head>
<body>
<Center>
<h1>Add Cinema</h1>
</Center>
<form name="input" action="control" method="post">
Location:      <input type="text" name="location"><br><br>
Seat Capacity:       <input type="text" name="seatcap"><br><br>
<table class="table table-hover">
				<tr>
					<th>Available</th>
					<th>Amenities</th>
				</tr>
				
				<tr>
				<td><input type="checkbox" name="selectedam" value="0"></td>
				<td>ATM</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedam" value="1"></td>
				<td>widescreen</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedam" value="2"></td>
				<td>snack bar</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedam" value="3"></td>
				<td>restaurant</td>
				</tr>
				
			</table>
<input type="hidden" name="action" value="addcinema"/>
<input type="submit" value="Save">
<a href="manager_home.jsp">Cancel</a>
</form><br>

</body>
</html>