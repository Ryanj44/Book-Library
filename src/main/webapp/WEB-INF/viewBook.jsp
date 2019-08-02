<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Information</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../css/book.css">
</head>
<body>
	<div id="header">
		<h1><c:out value="${book.title}"/></h1>
		<a id="library" href = "/books">Library</a>
		<a id="rList" href = "/books/readinglist">Reading List</a>
	</div>
	<div id="body">
		<p><img src="${book.image}" alt="Book Cover"></p>
		<p>Author: <c:out value = "${book.author}"/></p>
		<p>Number of Pages: <c:out value = "${book.pages}"/></p>
		<p>Publisher: <c:out value = "${book.publisher}"/></p>
		<p>Year Published: <c:out value = "${book.publishYear}"/></p>
		<p>Amazon Price: <c:out value = "${book.price}"/></p>
	</div>
</body>
</html>