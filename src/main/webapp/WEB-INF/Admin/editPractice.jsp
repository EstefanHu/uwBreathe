<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Practice</title>
</head>
<body>
	<h1>EDIT Practice</h1>
	<form:form method="PUT" action="/admin/updatePractice/${practice.getId()}" modelAttribute="updatePractice">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title" value="${practice.title}"/>
		</p>
		<input type="submit" value="Update"/>
	</form:form>
	<form:form method="DELETE" action="/admin/deletePractice/${practice.getId()}" modelAttribute="updatePractice">
		<input type="submit" value="Delete"/>
	</form:form>
	<a href="/admin">Back to Control</a>
</body>
</html>