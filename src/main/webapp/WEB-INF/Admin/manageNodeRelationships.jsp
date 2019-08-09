<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Nodes Relationships</title>
</head>
<body>
	<h1>All Resources</h1>
	<table>
		<thead>
			<tr>
				<th>Resource Title</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resources}" var="resource">
			<tr>
				<td><c:out value="${resource.title}"/></td>
				<td>
					<form:form method="POST" action="/admin/addResourceToNode/${resource.getId()}" modelAttribute="resource">
						<input type="submit" value="Add To Node"/>
					</form:form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>In Node</h1>
	<table>
		<thead>
			<tr>
				<th>Resource Title</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nodesResources}" var="nodesResources">
				<tr>
					<td><c:out value="${nodesResources.title}"/></td>
					<td>
						<form:form method="DELETE" action="/admin/removeNodesResources/${nodesResources.getId()}" modelAttribute="NodesResources">
							<input type="submit" value="Remove from Node"/>
						</form:form>
						<a href="/admin/updateNodesResources/${nodesResources.getId()}">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>All Practices</h1>
	<table>
		<thead>
			<tr>
				<th>Practice Title</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${practices}" var="practice">
			<tr>
				<td><c:out value="${practice.title}"/></td>
				<td>
					<form:form method="POST" action="/admin/addPracticeToNode/${practice.getId()}" modelAttribute="practice">
						<input type="submit" value="Add To Node"/>
					</form:form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>In Node</h1>
	<table>
		<thead>
			<tr>
				<th>Practice Title</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nodesPractices}" var="nodesPractice">
				<tr>
					<td><c:out value="${nodesPractice.title}"/></td>
					<td>
						<form:form method="DELETE" action="/admin/removeNodesPractices/${nodesPractice.getId()}" modelAttribute="PracticesNode">
							<input type="submit" value="Remove from Node"/>
						</form:form>
						<a href="/admin/updateNodesPractices/${nodesPractice.getId()}">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/admin/">Back to Control</a>
</body>
</html>