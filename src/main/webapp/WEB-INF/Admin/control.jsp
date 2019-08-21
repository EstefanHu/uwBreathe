<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/admin/admin.css" />
	<link rel="stylesheet" type="text/css" href="/css/admin/control.css" />
	<link rel="stylesheet" type="text/css" href="/css/admin/table.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<title>Control</title>
</head>

<body>
<div class="container">
	<div class="adminNav">
		<a href="/">
			<p class="navItem centerText firstNavItem">Map</p>
		</a>
		<div class="primaryNav">
			<a href="/admin/node">
				<p class="navItem centerText">Location</p>
			</a>
			<a href="/admin/practice">
				<p class="navItem centerText">Practice</p>
			</a>
			<a href="">
				<p class="navItem centerText">User</p>
			</a>
		</div>
		<a href="">
			<p class="navItem centerText lastNavItem">Logout</p>
		</a>
	</div>
<div class="controlGrid">
	<h1 class="centerText controlTitle">Admin Control</h1>
	<div class="locationBlock">
		<h2 class="centerText">Location Manager</h2>
		<table class=" center content-table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Theme</th>
					<th>Latitude</th>
					<th>Longitude</th>
					<th>Edit</th>
					<th>Manager</th>
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

	<div class="practiceBlock">
		<h2 class="centerText">Practice Manager</h2>
		<table class="content-table center">
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
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
							<c:out value="${practice.getDescription()}" />
						</td>
						<td>
							<a href="/admin/editPractice/<c:out value=" ${practice.getId()}" />">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="adminFooter centerText"><a href="/admin/createNode">New Node</a> - <a href="/admin/createPractice">New Practice</a></p>
	</div>
</div>
<img src="/imgs/site/splash.png" class="splash"/>
</div>
</body>   
