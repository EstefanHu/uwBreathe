<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Nodes for Path</title>
</head>
<body>
	<h1>All Nodes</h1>
	<table>
		<thead>
			<tr>
				<th>Node Id</th>
				<th>Node Title</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nodes}" var="node">
			<tr>
				<td><c:out value="${node.getId()}"/></td>
				<td><c:out value="${node.title}"/></td>
				<td>
					<form:form method="POST" action="/admin/addToPath/${node.getId()}" modelAttribute="node">
						<input type="submit" value="Add To Path"/>
					</form:form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>In Path</h1>
	<table>
		<thead>
			<tr>
				<th>Position</th>
				<th>Node Title</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pathsNodes}" var="PathsNodes">
				<tr>
					<td><c:out value="${PathsNodes.getId()}"/></td>
					<td><c:out value="${PathsNodes.title}"/></td>
					<td>
						<form:form method="DELETE" action="/admin/removePathsNodes/${PathsNodes.getId()}" modelAttribute="PathsNodes">
							<input type="submit" value="Remove from Path"/>
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Test</h1>
	<c:forEach items="${PathItems}" var="item">
		<p><c:out value="${item.title}"/></p>
	</c:forEach>
	<a href="/admin/">Back to Control</a>
</body>
</html>