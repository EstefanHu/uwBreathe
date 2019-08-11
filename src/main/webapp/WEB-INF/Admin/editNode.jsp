<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/admin.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<title>Edit Node</title>
</head>
<body>
<div class="container">
	<div class="adminGrid">
		<div class="adminNav">
			<a href="/" class="navHome">Home</a>
			<a href="/admin" class="navControl">Admin</a>
		</div>

		<h1 class="adminTitle centerText">Edit Node</h1>
		<div class="firstBlock center">
			<p>
				<form:errors path="updateNode.*" />
			</p>
			<form:form method="PUT" action="/admin/updateNode/${node.getId()}" modelAttribute="updateNode" class="creationForm">
				<p>
					<form:label path="title">Title:</form:label>
					<form:input path="title" value="${node.title}" />
				</p>
				<p>
					<form:label path="theme">Theme:</form:label>
					<form:input path="theme" value="${node.theme}" />
				</p>
				<p>
					<form:label path="latitude">Latitude:</form:label>
					<form:input path="latitude" value="${node.latitude}" />
				</p>
				<p>
					<form:label path="longitude">Longitude:</form:label>
					<form:input path="longitude" value="${node.longitude}" />
				</p>
				<input type="submit" value="Update" />
			</form:form>
		</div>
		<div class="secondBlock center">
			<form:form method="DELETE" action="/admin/deleteNode/${node.getId()}" modelAttribute="updateNode" class="delete">
				<input type="submit" value="Delete" />
			</form:form>
			<a href="/admin" class="centerText">Back to Control</a>
		</div>
	</div>
</div>
</body>
</html>