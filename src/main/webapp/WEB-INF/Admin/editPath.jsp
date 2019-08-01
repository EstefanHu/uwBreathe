<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Path</title>
</head>
<body>
	<p>EDIT PATH</p>
		<form:form method="PUT" action="/admin/updatePath/${path.getId()}" modelAttribute="updatePath">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title" value="${path.title}"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input path="description" value="${path.description}"/>
		</p>
		<p>
			<form:label path="theme">Theme:</form:label>
			<form:input path="theme" value="${path.theme}"/>
		</p>
		<p>
			<form:label path="timeDuration">Time Duration:</form:label>
			<form:input path="timeDuration" value="${path.timeDuration}"/>
		</p>
		<input type="submit" value="Update"/>
	</form:form>
		<form:form method="DELETE" action="/admin/deletePath/${path.getId()}" modelAttribute="updatePath">
		<input type="submit" value="Delete"/>
	</form:form>
	<a href="/admin">Back to Control</a>
</body>
</html>