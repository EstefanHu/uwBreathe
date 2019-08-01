<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Node</title>
</head>
<body>
	<h1>EDIT NODE</h1>
	<form:form method="PUT" action="updateNode" modelAttribute="updateNode">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title" placeholder="<c:out value="${node.title}"/>"/>
		</p>
		<p>
			<form:label path="latitude">Latitude:</form:label>
			<form:input path="latitude" placeholder="<c:out value="${node.latitude}"/>"/>
		</p>
		<p>
			<form:label path="longitude">Longitude:</form:label>
			<form:input path="longitude" placeholder="<c:out value="${node.longitude}"/>"/>
		</p>
	</form:form>
	<a href="/admin">Back to Control</a>
</body>
</html>