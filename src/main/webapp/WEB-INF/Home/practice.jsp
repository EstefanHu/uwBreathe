<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <title>Practice View</title>
</head>
<body>
<div class="container">
<div class="practiceGrid">
    <div class="practiceNav centerText">
        <a href="/" class="navMap">Map</a>
        <a href="/profile" class="navProfile">Profile</a>
        <a href="/" class="navBack">Back</a>
    </div>
    <h1 class="practiceTitle centerText"><c:out value="${practice.title}"/></h1>
    <div class="practiceImage"></div>
    <div class="primaryBlock">
        <c:out value="${practice.description}" />
    </div>
    <div class="secondaryBlock">
    </div>
</div>
</div>
</body>
</html>