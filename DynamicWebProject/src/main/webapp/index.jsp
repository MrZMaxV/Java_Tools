<%@page import="ua.com.foxminded.db.DatabaseFacade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List of books</h1>
	<%
	for (String name : DatabaseFacade.getBooks()) {
		out.print(name + "<br/>");
	}
	%>

	<h2>Add a new book</h2>
	<form action="AddBookServlet" method="post">
		<label for="bookName">Book Name:</label> <input type="text"
			id="bookName" name="bookName"><br> <br> <input
			type="submit" value="Add Book">
	</form>

	<h3>Remove a book</h3>
	<form action="RemoveBookServlet" method="post">
		<label for="bookToRemove">Select Book to Remove:</label> <select
			id="bookToRemove" name="bookToRemove">
			<%
			for (String name : DatabaseFacade.getBooks()) {
			%>
			<option value="<%=name%>"><%=name%></option>
			<%
			}
			%>
		</select><br>
		<br> <input type="submit" value="Remove Book">
	</form>


</body>
</html>