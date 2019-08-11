<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<title>Location View</title>
</head>
<body>
<div class="container">
<div class="locationGrid">
	<div class="locationNav centerText">
		<a href="/" class="navMap">Map</a>
		<a href="/profile" class="navProfile">Profile</a>
		<a href="/" class="navBack">Back</a>
	</div>
	<h1 class="locationTitle centerText"><c:out value="${node.title}"/></h1>
	<div class="locationImage"></div>
	<div class="primaryBlock">
		<c:forEach items="${node.getPractices()}" var="practice">
			<a href="/practice/<c:out value='${practice.getId()}'/>" class="practiceWrapper">
				<div class="practiceItem">
					<p><c:out value="${practice.title}" /></p>
				</div>
			</a>
		</c:forEach>
	</div>
	<div class="secondaryBlock"></div>
</div>
</div>
</body>
</html>