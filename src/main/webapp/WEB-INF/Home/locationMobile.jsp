<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/css/location.css"/>
<title>Location View</title>
</head>
<body>
<div class="container">
<div class="locationGrid">
	<a href="/<c:out value='${node.theme}'/>" class="backToLocations">Locations</a>
	<h1 class="locationTitle"><c:out value="${node.title}"/></h1>
	<div class="locationImg">
		<div class="imageOverlay">
			<img src="/imgs/<c:out value='${node.photo}'/>">
		</div>
		<div class="locationDescription">
			<p><c:out value="${node.description}" /></p>
		</div>
	</div>
	<div class="directionButton centerText">
		<a href="<c:out value='${node.navigationUrl}'/>">
			<button class="getDirections">Start directions</button>	
		</a>
	</div>
	<div class="locationsPractices">
		<hr>
		<p class="availableP">Available Practice</p>
		<div class="itemHolder">
		<c:forEach items="${node.getPractices()}" var="practice">
			<a href="/practice/<c:out value='${practice.getId()}'/>" class="practiceWrapper">
				<div class="practiceItem centerText">
					<h3>B</h3>
					<p><c:out value="${practice.title}" /></p>
				</div>
			</a>
		</c:forEach>
		</div>
	</div>
</div>
</div>
</body>
</html>