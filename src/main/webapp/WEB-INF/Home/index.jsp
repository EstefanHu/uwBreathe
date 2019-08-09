<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
	  integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
	  crossorigin=""/>
	<link rel="stylesheet" type="css/text" href="css/style.css"/>
	<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
	  integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
	  crossorigin=""></script>
	<title>Home Page</title>
</head>
<body>
<div class="container">
	<div id="mapid"></div>
	<div class="sidebar centerText">
	<c:choose>
		<c:when test="${themedNodes.size() != null}">
			<h1>Locations</h1>
			<c:forEach items="${themedNodes}" var="node">
				<a href="/location/${node.getId()}">
					<div class="sidebarItem center">
						<c:out value="${node.title}"/>
					</div>
				</a>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>Themes</h1>
				<a href="/Stillness"><div  class="sidebarItem center">Stillness</div></a>
				<a href="/Generative"><div class="sidebarItem center">Generative</div></a>
				<a href="/Creative"><div class="sidebarItem center">Creative</div></a>
				<a href="/Activist"><div class="sidebarItem center">Activist</div></a>
				<a href="/Relational"><div class="sidebarItem center">Relational</div></a>
				<a href="/Movement"><div class="sidebarItem center">Movement</div></a>	
				<a href="/Ritual"><div class="sidebarItem center">Ritual</div></a>					
			</div>
		</c:otherwise>
	</c:choose>
</div>
</body>
<script type="text/javascript" src="js/map.js"></script>
<c:if test="${themedNodes.size() != null}">
	<c:forEach items="${themedNodes}" var="node">
		<script>
			var marker = L.marker(['${node.latitude}', '${node.longitude}']).addTo(mymap);
		</script>
	</c:forEach>
</c:if>
</html>