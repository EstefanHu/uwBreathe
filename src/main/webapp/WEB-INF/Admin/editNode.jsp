<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Node</title>
</head>
<body>
	<h1>EDIT NODE</h1>
	<form:form method="PUT" action="/admin/updateNode/${node.getId()}" modelAttribute="updateNode">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title" value="${node.title}"/>
		</p>
		<p>
			<form:label path="theme">Theme:</form:label>
			<form:input path="theme" value="${node.theme}"/>
		</p>
		<p>
			<form:label path="latitude">Latitude:</form:label>
			<form:input path="latitude" value="${node.latitude}"/>
		</p>
		<p>
			<form:label path="longitude">Longitude:</form:label>
			<form:input path="longitude" value="${node.longitude}"/>
		</p>
		<input type="submit" value="Update"/>
	</form:form>
	<form:form method="DELETE" action="/admin/deleteNode/${node.getId()}" modelAttribute="updateNode">
		<input type="submit" value="Delete"/>
	</form:form>
	<a href="/admin">Back to Control</a>
</body>
</html>