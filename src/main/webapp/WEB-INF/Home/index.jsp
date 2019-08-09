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
	<div class="sidebar center">
	<c:choose>
		<c:when test="{themedNodes}">
			<h1>Testing</h1>
		</c:when>
		<c:otherwise>
			<h1 class="center">Themes</h1>
				<a class="theme" id="stillness" href="/stillness">Stillness</a>
				<a class="theme" id="generative" href="/generative">Generative</a>
				<a class="theme" id="creative" href="/creative">Creative</a>
				<a class="theme" id="activist" href="/activist">Activist</a>
				<a class="theme" id="relational" href="/relational">Relational</a>
				<a class="theme" id="movement" href="/movement">Movement</a>	
				<a class="theme" id="ritual" href="/ritual">Ritual</a>					
			</div>
		</c:otherwise>
	</c:choose>
</div>
</body>
<script type="text/javascript" src="js/map.js"></script>
</html>