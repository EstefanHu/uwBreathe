<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
        integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
        crossorigin="" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/css/information.css" />
    <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
        integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
        crossorigin=""></script>
    <title>Practice View</title>
</head>
<body>
<div class="container">
<div id="mapid"></div>
<div class="mainContent">
    <div class="themeBar">
        <a href="/location/<c:out value='${chosenNode.getId()}'/>" class="back"><c:out value="${chosenNode.title}"/></a>
        <h1 class="greetings"><c:out value="${practice.title}" /> at <c:out value="${chosenNode.title}" /></h1>
        <img src="/imgs/site/splash.png" />
        <p class="practiceDescription"><c:out value="${practice.description}" /></p>
        <div class="detailHolder">
            <hr>
            <h4>Practice Steps</h4>
            
            <h4>Notes from Students <span class="createComment" onclick="comment()"><p>+</p></span></h4>
            <div class="itemHolder">

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