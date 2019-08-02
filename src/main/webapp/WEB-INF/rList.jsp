<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reading List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../css/rList.css">
</head>
<body>
<div id="body">
	<div id="header">
		<h1>Reading List</h1>
		<a id = "library" href = "/books">Library</a>
	</div>
	<table class = "table table-dark">
		<thead>
			<tr>
				<th id="title">Title</th>
				<th id="author">Author</th>
				<th id="publisher">Publisher</th>
				<th id="pages">Pages</th>
				<th id="action">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rList}" var="book">
			<tr>
				<td id="book_title"><c:out value = "${book.book.title}"/></td>
				<td id="book_author"><c:out value = "${book.book.author}"/></td>
				<td id="book_publisher"><c:out value = "${book.book.publisher}"/></td>
				<td id="book_pages"><c:out value = "${book.book.pages}"/></td>
				<td id="book_actions"><a href="/books/${book.book.id}/remove">Remove from Reading List</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>