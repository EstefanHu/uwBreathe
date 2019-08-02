<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Resource</title>
</head>
<body>
	<h1>Create Resource</h1>
	<form:form method="POST" action="ingestNewResource" modelAttribute="resource">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input path="description"/>
		</p>
		<p>
			<form:label path="url">Url:</form:label>
			<form:input path="url"/>
		</p>
		<p>
			<form:label path="email">Email Address:</form:label>
			<form:input path="email"/>
		</p>
		<p>
			<form:label path="phoneNumber">Phone Number:</form:label>
			<form:input path="phoneNumber"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
	<a href="/admin">Back to Control</a>
</body>
</html>