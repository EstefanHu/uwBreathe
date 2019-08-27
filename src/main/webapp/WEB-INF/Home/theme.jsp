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
                <a href="/location/${node.getId()}">
                    <div class="themebarItem" style="background-image: url(imgs/<c:out value='${node.photo}'/>);" >
                        <p>
                            <c:out value="${node.title}" />
                        </p>
                    </div>
                </a>
                </c:forEach>
            </div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/js/map.js"></script>
<c:forEach items="${themedNodes}" var="node">
    <script>
        var marker = L.marker(['${node.latitude}', '${node.longitude}']).bindPopup(
            '<p><c:out value="${node.title}" /></p>' + 
            '<img src="/imgs/<c:out value="${node.photo}"/>" alt="">' +
            '<p><c:out value="${node.theme}" /></p>'
            ).addTo(mymap);
    </script>
</c:forEach>
</body>
</html>