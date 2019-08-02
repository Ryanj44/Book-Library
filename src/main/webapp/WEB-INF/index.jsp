<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/books" method="POST" modelAttribute="book">
		<p>
			<form:label path="title">Title: </form:label>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="author">Author: </form:label>
			<form:input path="author"/>
		</p>		
		<p>
			<form:label path="publisher">Publisher: </form:label>
			<form:input path="publisher"/>
		</p>
		<p>
			<form:label path="publishYear">Publish Year: </form:label>
			<form:input type="number" path="publishYear"/>
		</p>
				<p>
			<form:label path="pages">Pages: </form:label>
			<form:input type="number" path="pages"/>
		</p>
		<p>
			<form:label path="price">Price: </form:label>
			<form:input type="double" path="price"/>
		</p>
		<p>
			<form:label path="image">Image: </form:label>
			<form:input path="image"/>
		</p>
		<input type="submit" value="Create Book"/>
	</form:form>
</body>
</html>