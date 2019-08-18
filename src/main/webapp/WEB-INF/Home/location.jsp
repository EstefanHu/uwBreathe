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
	<div class="locationImage center">
		<img src="/imgs/<c:out value='${node.photo}'/>" class="lImage">
	</div>
	<div class="primaryBlock center">
		<p><c:out value="${node.description}"/></p>
		<a href="<c:out value='${node.navigationUrl}'/>">
			<button id="getDirections">Get directions</button>	
		</a>
	</div>
	<div class="secondaryBlock">
		<p>Available Practice</p>
		<c:forEach items="${node.getPractices()}" var="practice">
			<a href="/practice/<c:out value='${practice.getId()}'/>" class="practiceWrapper">
				<div class="practiceItem">
					<p>
						<c:out value="${practice.title}" />
					</p>
				</div>
			</a>
		</c:forEach>
	</div>
</div>
</div>
</body>
</html>