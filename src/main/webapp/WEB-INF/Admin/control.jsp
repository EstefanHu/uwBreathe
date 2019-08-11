<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/admin.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<title>Control</title>
</head>

<body>
<div class="container">
<div class="adminGrid">
	<div class="adminNav">
		<a href="/" class="navHome">Home</a>
		<a href="/admin" class="navControl">Admin</a>
	</div>

	<h1 class="centerText adminTitle">Admin Control</h1>
	<div class="firstBlock">
		<h2 class="centerText">Node Manager</h2>
		<table class="nodeTable centerText center">
			<thead>
				<tr>
					<th>Title</th>
					<th>Theme</th>
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
							<c:out value="${node.theme}" />
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
	</div>

	<div class="secondBlock">
		<h2 class="centerText">Practice Manager</h2>
		<table class="practiceTable centerText center">
			<thead>
				<tr>
					<th>Title</th>
					<th>Duration</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${practices}" var="practice">
					<tr>
						<td>
							<c:out value="${practice.getTitle()}" />
						</td>
						<td>
						</td>
						<td>
							<a href="/admin/editPractice/<c:out value=" ${practice.getId()}" />">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<footer class="centerText">
	<p>
		<a href="/admin/createNode">New Node</a> - <a href="/admin/createPractice">New Practice</a>
	</p>
</footer>
</div>
</body>   
