<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/css/practice.css"/>
    <title>Practice View</title>
</head>
<body>
<div class="container">
<div class="mainContent">
    <div class="themeBar">
        <a href="/">Location</a>
        <h1 class="centerText"><c:out value="${practice.title}" /></h1>
        <
    </div>
    <div class="primaryBlock">
        <c:out value="${practice.description}" />
    </div>

</div>
</div>
</body>
</html>