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
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="createPath">New Path</a>
	<a href="createNode">New Node</a>
</body>   
