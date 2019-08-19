<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/admin.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<title>Edit Practice</title>
</head>
<body>
<div class="container">
	<div class="adminGrid">
		<div class="adminNav">
			<a href="/" class="navHome">Home</a>
			<a href="/admin" class="navControl">Admin</a>
		</div>

		<h1 class="adminTitle centerText">Edit Practice</h1>
		<div class="firstBlock center">
			<p>
				<form:errors path="updatePractice.*" />
			</p>
			<form:form method="PUT" action="/admin/updatePractice/${practice.getId()}" modelAttribute="updatePractice"
				class="creationForm">
				<p>
					<form:label path="title">Title:</form:label>
					<form:input path="title" value="${practice.title}" />
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:input path="description" value="${practice.description}" />
				</p>
				<input type="submit" value="Update" />
			</form:form>
		</div>
		<div class="secondBlock center">
			<form:form method="DELETE" action="/admin/deletePractice/${practice.getId()}" modelAttribute="updatePractice"
				class="delete">
				<input type="submit" value="Delete" />
			</form:form>
			<a href="/admin" class="centerText">Back to Control</a>
		</div>
	</div>
</div>
</body>
</html>