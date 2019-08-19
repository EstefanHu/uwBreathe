<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/admin.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<title>Manage Nodes Relationships</title>
</head>
<body>
	<div class="adminGrid">
		<div class="adminNav">
			<a href="/" class="navHome">Home</a>
			<a href="/admin" class="navControl">Admin</a>
		</div>

		<h1 class="adminTitle centerText">Manage Nodes Relationships</h1>
		<div class="firstBlock">
			<h2 class="centerText">All Practices</h2>
			<table class="centerText center">
				<thead>
					<tr>
						<th>Practice Title</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${practices}" var="practice">
						<tr>
							<td>
								<c:out value="${practice.title}" />
							</td>
							<td>
								<form:form method="POST" action="/admin/addPracticeToNode/${practice.getId()}"
									modelAttribute="practice">
									<input type="submit" value="Add To Node" />
								</form:form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="secondBlock centerText center">
			<h2 class="centerText">Practices in Node</h2>
			<table class="centerText center">
				<thead>
					<tr>
						<th>Practice Title</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${nodesPractices}" var="nodesPractice">
						<tr>
							<td>
								<c:out value="${nodesPractice.title}" />
							</td>
							<td>
								<form:form method="DELETE" action="/admin/removeNodesPractices/${nodesPractice.getId()}"
									modelAttribute="PracticesNode">
									<input type="submit" value="Remove from Node" />
								</form:form>
								<a href="/admin/updateNodesPractices/${nodesPractice.getId()}">Update</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<a href="/admin/">Back to Control</a>
		</div>
	</div>
</body>
</html>