<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Resource</title>
</head>
<body>
	<h1>EDIT Resource</h1>
	<form:form method="PUT" action="/admin/updateResource/${resource.getId()}" modelAttribute="updateResource">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title" value="${resource.title}"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input path="description" value="${resource.description}"/>
		</p>
		<p>
			<form:label path="url">Url:</form:label>
			<form:input path="url" value="${resource.url}"/>
		</p>
		<p>
			<form:label path="email">Email Address:</form:label>
			<form:input path="Email" value="${resource.email}"/>
		</p>
		<p>
			<form:label path="phoneNumber">Phone Number:</form:label>
			<form:input path="phoneNumber" value="${resource.phoneNumber}"/>
		</p>
		<input type="submit" value="Update"/>
	</form:form>
	<form:form method="DELETE" action="/admin/deleteResource/${resource.getId()}" modelAttribute="updateResource">
		<input type="submit" value="Delete"/>
	</form:form>
	<a href="/admin">Back to Control</a>
</body>
</html>