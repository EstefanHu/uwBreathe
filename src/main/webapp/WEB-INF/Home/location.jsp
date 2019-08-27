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
	<link rel="stylesheet" type="text/css" href="/css/location.css" />    
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
		</div>
	</div>
</div>
<script type="text/javascript" src="/js/zoomMap.js" lat="${chosenNode.latitude}" lon="${chosenNode.longitude}"></script>
<script>
    var marker = L.marker(['${chosenNode.latitude}', '${chosenNode.longitude}']).bindPopup(
        '<p><c:out value="${chosenNode.title}" /></p>' + 
        '<img src="/imgs/<c:out value="${chosenNode.photo}"/>" alt="">' +
        '<p><c:out value="${chosenNode.theme}" /></p>'
        ).addTo(mymap);
</script>
</body>
</html>