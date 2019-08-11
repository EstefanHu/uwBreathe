<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="css/text" href="/css/admin.css" />
	<link rel="stylesheet" type="css/text" href="/css/style.css" />
	<title>Control</title>
</head>
<body>
<div class="container">
	<div class="adminGrid">
		<div class="adminNav">
			<p class="centerText">Testing</p>
		</div>
		<h1 class="centerText adminTitle">Admin Control</h1>

		<table class="nodeTable">
			<thead><tr><th><h1>Node Controller</h1></th></tr></thead>
			<thead>
				<tr>
					<th>Title</th>
					<th>Latitude</th>
					<th>Longitude</th>
					<th>Edit</th>
					<th>Resource Manager</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${nodes}" var="node">
					<tr>
						<td>
							<c:out value="${node.title}" />
						</td>
						<td>
							<c:out value="${node.latitude}" />
						</td>
						<td>
							<c:out value="${node.longitude}" />
						</td>
						<td><a href="/admin/editNode/<c:out value=" ${node.getId()}" />">Edit</a></td>
						<td><a href="/admin/manageNodeRelationships/<c:out value=" ${node.getId()}" />">Manage</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table class="practiceTable">
			<thead><tr><th><h1>Practice Controller</h1></th></tr></thead>
			<thead>
				<tr>
					<th>Title</th>
					<th>Node Manager</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${practices}" var="practice">
					<tr>
						<td>
							<c:out value="${practice.getTitle()}" />
						</td>
						<td><a href="/admin/editPractice/<c:out value=" ${practice.getId()}" />">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="/admin/createNode">New Node</a>
	<a href="/admin/createPractice">New Practice</a>
</div>
</body>   
