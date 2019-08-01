<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Control</title>
</head>
<body>
	<h1>All Paths</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Description</th>
	            <th>Theme</th>
	            <th>Number of Nodes</th>
	            <th>Time Duration</th>
	            <th>Edit</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${paths}" var="path">
	        <tr>
	            <td><c:out value="${path.title}"/></td>
	            <td><c:out value="${path.description}"/></td>
	            <td><c:out value="${path.theme}"/></td>
	            <td><c:out value="${path.numOfNodes}"/></td>
	            <td><c:out value="${path.timeDuration}"/></td>
	            <td><a href="/admin/editPath/<c:out value="${path.getId()}"/>">Edit</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<h1>All Nodes</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Latitude</th>
	            <th>Longitude</th>
	            <th>Edit</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${nodes}" var="node">
	        <tr>
	            <td><c:out value="${node.title}"/></td>
	            <td><c:out value="${node.latitude}"/></td>
	            <td><c:out value="${node.longitude}"/></td>
	            <td><a href="/admin/editNode/<c:out value="${node.getId()}"/>">Edit</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="createPath">New Path</a>
	<a href="createNode">New Node</a>
</body>   
