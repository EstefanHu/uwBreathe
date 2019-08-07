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
	<form:form method="POST" action="ingestNewPractice" modelAttribute="practice">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
	<a href="/admin">Back to Control</a>
</body>
</html>