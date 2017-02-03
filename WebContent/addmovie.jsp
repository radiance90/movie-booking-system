<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Movie</title>
</head>
<body>
<Center>
<h1>Add Movie</h1>
</Center>
<form name="input" action="control" method="post">
Title:      <input type="text" name="title"><br><br>
Poster:       <input type="text" name="poster"><br><br>
Actors and Actresses:       <input type="text" name="cast"><br><br>
<table class="table table-hover">
				<tr>
					<th></th>
					<th>Genre</th>
				</tr>
				
				<tr>
				<td><input type="checkbox" name="selectedgenre" value="0"></td>
				<td>Romance</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedgenre" value="1"></td>
				<td>Horror</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedgenre" value="2"></td>
				<td>Thriller</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedgenre" value="3"></td>
				<td>Comedy</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedgenre" value="4"></td>
				<td>Drama</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedgenre" value="5"></td>
				<td>Biopic</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="selectedgenre" value="6"></td>
				<td>Action</td>
				</tr>
				
			</table><br>
Director:      <input type="text" name="director"><br><br>
Synopsis:      <input type="text" name="synopsis"><br><br>
Release Time:      <input type="text" name="release"><br><br>
Age rating:      <input type="text" name="age"><br><br>
<input type="hidden" name="action" value="addmovie"/>
<input type="submit" value="Save">
<a href="manager_home.jsp">Cancel</a>
</form><br>
</body>
</html>