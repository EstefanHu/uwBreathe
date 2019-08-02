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
	            <th>Time Duration</th>
	            <th>Edit</th>
	            <th>Node Manager</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${paths}" var="path">
	        <tr>
	            <td><c:out value="${path.title}"/></td>
	            <td><c:out value="${path.description}"/></td>
	            <td><c:out value="${path.theme}"/></td>
	            <td><c:out value="${path.timeDuration}"/></td>
	            <td><a href="/admin/editPath/<c:out value="${path.getId()}"/>">Edit</a></td>
	            <td><a href="/admin/editNodeForPath/<c:out value="${path.getId()}"/>">Manage</a></td>
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
	            <th>Resource Manager</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${nodes}" var="node">
	        <tr>
	            <td><c:out value="${node.title}"/></td>
	            <td><c:out value="${node.latitude}"/></td>
	            <td><c:out value="${node.longitude}"/></td>
	            <td><a href="/admin/editNode/<c:out value="${node.getId()}"/>">Edit</a></td>
        	    <td><a href="/admin/editResourceForNode/<c:out value="${node.getId()}"/>">Manage</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<h1>All Resources</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Description</th>
	            <th>URL</th>
	            <th>Email Address</th>
	            <th>Phone Number</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${resources}" var="resource">
	        <tr>
	            <td><c:out value="${resource.title}"/></td>
	            <td><c:out value="${resource.description}"/></td>
	            <td><c:out value="${resource.url}"/></td>
	            <td><c:out value="${resource.email}"/></td>
	            <td><c:out value="${resource.phoneNumber}"/></td>
	            <td><a href="/admin/editResource/<c:out value="${resource.getId()}"/>">Edit</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="/admin/createPath">New Path</a>
	<a href="/admin/createNode">New Node</a>
	<a href="/admin/createResource">New Resource</a>
</body>   
