<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/admin/admin.css" />
	<link rel="stylesheet" type="text/css" href="/css/admin/node.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<title>Create Node</title>
</head>

<body>
<div class="container">
	<div class="adminGrid">
		<div class="adminNav">
			<a href="/" class="navHome">Home</a>
			<a href="/admin" class="navControl">Admin</a>
		</div>
		
		<h1 class="adminTitle centerText">Create a New Node</h1>
		<div class="firstBlock center">
			<p>
				<form:errors path="node.*" />
			</p>
			<form:form method="POST" action="createNewNode" modelAttribute="node" class="creationForm">
				<p>
					<form:label path="title">Title:</form:label>
					<form:input path="title" />
				</p>
				<p>
					<form:label path="theme">Theme:</form:label>
					<form:input path="theme" />
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:input path="description" />
				</p>
				<p>
					<form:label path="navigationUrl">Navigation Url</form:label>
					<form:input path="navigationUrl" />
				</p>
				<p>
					<form:label path="photo">Photo:</form:label>
					<form:input path="photo"/>
				</p>
				<p>
					<form:label path="latitude">Latitude:</form:label>
					<form:input path="latitude" />
				</p>
				<p>
					<form:label path="longitude">Longitude:</form:label>
					<form:input path="longitude" />
				</p>
				<input type="submit" value="Submit" />
			</form:form>
		</div>
			<a href="/admin" class="secondBlock centerText">Back to Control</a>
	</div>
</div>
</body>
</html>