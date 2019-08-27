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
			<h1 class="greetings">Good morning. <br>Pick a theme to explore!</h1>
			<div class="themebarGrid">
				<a href="/Stillness"><img src="/imgs/site/Stillness.png" /></a>
				<a href="/Generative"><img src="/imgs/site/Generative.png" /></a>
				<a href="/Creative"><img src="/imgs/site/Creative.png" /></a>
				<a href="/Relational"><img src="/imgs/site/Relational.png" /></a>
				<a href="/Movement"><img src="/imgs/site/Movement.png" /></a>
				<a href="/Ritual"><img src="/imgs/site/Ritual.png" /></a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/js/map.js"></script>
</body>
</html>