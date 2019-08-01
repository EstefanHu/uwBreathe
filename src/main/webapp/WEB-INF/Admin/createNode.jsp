<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Node</title>
</head>
<body>
	<h1>Hello Create Node View!</h1>
	<p><form:errors path="node.*"/></p>
	<form:form method="POST" action="ingestNewNode" modelAttribute="node">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="latitude">Latitude:</form:label>
			<form:input path="latitude"/>
		</p>
		<p>
			<form:label path="longitude">Longitude:</form:label>
			<form:input path="longitude"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>