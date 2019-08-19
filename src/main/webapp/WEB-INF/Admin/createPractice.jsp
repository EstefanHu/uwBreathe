<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/admin.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<title>Create Resource</title>
</head>

<body>
<div class="container">
<div class="adminGrid">
	<div class="adminNav">
		<a href="/" class="navHome">Home</a>
		<a href="/admin" class="navControl">Admin</a>
	</div>

	<h1 class="adminTitle centerText">Create a New Practice</h1>
	<div class="firstBlock center">
		<p>
			<form:errors path="practice.*" />
		</p>
		<form:form method="POST" action="createNewPractice" modelAttribute="practice" class="creationForm">
			<p>
				<form:label path="title">Title:</form:label>
				<form:input path="title" />
			</p>
			<p>
				<form:label path="description">Description:</form:label>
				<form:input path="description" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
	<a href="/admin" class="secondBlock centerText">Back to Control</a>
</div>
</div>
</body>
</html>