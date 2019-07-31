<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Path</title>
</head>
<body>
	<h1>Hello Create Path View!</h1>
	<p><form:errors path="path.*"/></p>
	<form:form method="POST" action="/ingestnewpath" modelAttribute="path">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="theme">Theme:</form:label>
			<form:input path="theme"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input path="description"/>
		</p>
		<p>
			<form:label path="timeDuration">How Long is this?</form:label>
			<form:input path="timeDuration"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>