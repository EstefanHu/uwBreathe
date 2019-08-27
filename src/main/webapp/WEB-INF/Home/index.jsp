<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
	  integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
	  crossorigin=""/>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/css/index.css" />
	<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
	  integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
	  crossorigin=""></script>
	<title>Home Page</title>
</head>
<body>
<div class="container">
	<div id="mapid"></div>
	<div class="mainContent">
		<div class="themeBar">
			<img src="imgs/site/downarrow.png" class="downarrow centerText">
			<c:choose>
				<c:when test="${themedNodes.size() != null}">
					<a href="/" class="backLink">Back</a>
					<c:choose>
						<c:when test="${theme.equals('Stillness')}">
							<h1 class="greetings">Relax and Restore</h1>
						</c:when>
						<c:when test="${theme.equals('Generative')}">
							<h1 class="greetings">Personal Visualization</h1>
						</c:when>
						<c:when test="${theme.equals('Creative')}">
							<h1 class="greetings">Be Creative</h1>
						</c:when>
						<c:when test="${theme.equals('Relational')}">
							<h1 class="greetings">Restoring Through Others</h1>
						</c:when>
						<c:when test="${theme.equals('Movement')}">
							<h1 class="greetings">Wake up Your Body</h1>
						</c:when>
						<c:when test="${theme.equals('Ritual')}">
							<h1 class="greetings">Habitual Reflection</h1>
						</c:when>
						<c:otherwise>
							<h1 class="greetings">Lets Take Some Action</h1>
						</c:otherwise>
					</c:choose>
					<div class="themebarGrid" >
						<c:forEach items="${themedNodes}" var="node">
						<a href="/locationCheck/${node.getId()}/0">
							<div class="themebarItem" style="background-image: url(imgs/<c:out value='${node.photo}'/>);">
								<p>
									<c:out value="${node.title}" />
								</p>
							</div>
						</a>
						</c:forEach>
					</div>
				</c:when>
				<c:when test="${chosenNode.getId() != null}">
					<a href="/<c:out value='${chosenNode.theme}'/>" class="backToLocations">Locations</a>
					<h1 class="locationTitle"><c:out value="${chosenNode.title}"/></h1>
					<div class="locationImg">
						<div class="imageOverlay">
							<img src="/imgs/<c:out value='${chosenNode.photo}'/>">
						</div>
						<div class="locationDescription">
							<p><c:out value="${chosenNode.description}" /></p>
						</div>
					</div>
					<div class="directionButton centerText">
						<a href="<c:out value='${chosenNode.navigationUrl}'/>">
							<button class="getDirections">Start directions</button>	
						</a>
					</div>
					<div class="locationsPractices">
						<hr>
						<p class="availableP">Available Practice</p>
						<div class="itemHolder">
						<c:forEach items="${chosenNode.getPractices()}" var="practice">
							<a href="/practice/<c:out value='${practice.getId()}'/>" class="practiceWrapper">
								<div class="practiceItem centerText">
									<h3>B</h3>
									<p><c:out value="${practice.title}" /></p>
								</div>
							</a>
						</c:forEach>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<h1 class="greetings">Good morning. <br>Pick a theme to explore!</h1>
					<div class="themebarGrid">
						<a href="/Stillness"><img src="/imgs/site/Stillness.png" /></a>
						<a href="/Generative"><img src="/imgs/site/Generative.png" /></a>
						<a href="/Creative"><img src="/imgs/site/Creative.png" /></a>
						<a href="/Relational"><img src="/imgs/site/Relational.png" /></a>
						<a href="/Movement"><img src="/imgs/site/Movement.png" /></a>
						<a href="/Ritual"><img src="/imgs/site/Ritual.png" /></a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<c:choose>
<c:when test="${chosenNode.getId() != null}">
	<script type="text/javascript" src="/js/zoomMap.js" lat="${chosenNode.latitude}" lon="${chosenNode.longitude}"></script>
</c:when>
<c:otherwise>
	<script type="text/javascript" src="/js/map.js"></script>
</c:otherwise>
</c:choose>
<c:if test="${themedNodes.size() != null}">
	<c:forEach items="${themedNodes}" var="node">
		<script>
			var marker = L.marker(['${node.latitude}', '${node.longitude}']).bindPopup(
				'<p><c:out value="${node.title}" /></p>' + 
				'<img src="/imgs/<c:out value="${node.photo}"/>" alt="">' +
				'<p><c:out value="${node.theme}" /></p>'
				).addTo(mymap);
		</script>
	</c:forEach>
</c:if>
<c:if test="${chosenNode.getId() != null}">
	<script>
		var marker = L.marker(['${chosenNode.latitude}', '${chosenNode.longitude}']).bindPopup(
			'<p><c:out value="${chosenNode.title}" /></p>' + 
			'<img src="/imgs/<c:out value="${chosenNode.photo}"/>" alt="">' +
			'<p><c:out value="${chosenNode.theme}" /></p>'
			).addTo(mymap);
	</script>
</c:if>
</body>
</html>