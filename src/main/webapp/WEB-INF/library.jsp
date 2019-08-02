<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../css/library.css">
</head>
<body>
<div id="body">
	<div id="header">
		<h1>Library</h1>
		<a id = "reading" href = "/books/readinglist">Reading List</a>
	</div>
		<table class = "table table-dark">
			<thead>
				<tr>
					<th id="title"><a href="/books/title">Title</a></th>
					<th id="author"><a href="/books/author">Author</a></th>
					<th id="publisher">Publisher</th>
					<th id="pages"><a href="/books/pages">Pages</a></th>
					<th id="read">Read</th>
					<th id="actions">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td id="book_title"><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td id="book_author"><c:out value="${book.author}"/></td>
						<td id="book_publisher"><c:out value="${book.publisher}"/></td>
						<td id="book_pages"><c:out value="${book.pages}"/></td>
						<td id="book_read">
							<c:if test = "${book.finished == false}">No</c:if>
							<c:if test ="${book.finished == true }">Yes</c:if>	
						</td>	
						<td id="book_actions">
							<c:set var="red" value="${false}"/>
							<c:forEach items="${rList}" var="reading">
								<c:if test="${reading.book == book }">
									<c:set var= "red" value="${true}"/>
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${red == false }">
									<a href = "/books/${book.id}/add">Add to Reading List</a>
								</c:when>
								<c:otherwise>
									<a href = "/books/${book.id}/remove">Remove from Reading List</a>
								</c:otherwise>
							</c:choose>|
							<c:if test="${book.finished == false}"><a href="/books/${book.id}/read">Mark as Read</a></c:if>
							<c:if test="${book.finished == true}"><a href="/books/${book.id}/unread">Mark as Unread</a></c:if>
						</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</body>
</html>