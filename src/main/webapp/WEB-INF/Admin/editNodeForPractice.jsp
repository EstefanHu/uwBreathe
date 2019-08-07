<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Node for Practice</title>
</head>
<body>
	<h1>All Nodes</h1>
	<table>
		<thead>
			<tr>
				<th>Node Title</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nodes}" var="node">
			<tr>
				<td><c:out value="${node.title}"/></td>
				<td>
					<form:form method="POST" action="/admin/addToPractice/${node.getId()}" modelAttribute="node">
						<input type="submit" value="Add To Practice"/>
					</form:form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>In Practice</h1>
	<table>
		<thead>
			<tr>
				<th>Resource Title</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${practicesNodes}" var="practicesNode">
				<tr>
					<td><c:out value="${practicesNode.title}"/></td>
					<td>
						<form:form method="DELETE" action="/admin/removePracticesNodes/${practicesNode.getId()}" modelAttribute="PracticesNodes">
							<input type="submit" value="Remove from Practice"/>
						</form:form>
						<a href="/admin/updatePracticesNodes/${practicesNode.getId()}">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/admin/">Back to Control</a>
</body>
</html>