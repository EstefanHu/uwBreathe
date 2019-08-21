<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="/css/admin/admin.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin/practice.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin/modal.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <title>Practice Manager</title>
</head>
<body>
<div class="container">
<div class="practiceGrid">
    <div class="adminNav">
        <a href="/">
            <div class="navItem">
                <p>M</p>
            </div>
        </a>
        <a href="/admin/node">
            <div class="navItem">
                <p>L</p>
            </div>
        </a>
        <a href="/admin/practice">
            <div class="navItem">
                <p>P</p>
            </div>
        </a>
        <a href="">
            <div class="navItem">
                <p>U</p>
            </div>
        </a>
        <a href="">
            <div class="navItem">
                <p>L</p>
            </div>
        </a>
    </div>
    <div class="practiceTable">
        <div class="practiceTableHead">
            <a href="/admin/practice">
                <div>
                    <p class="centerText tableIndex">Stats</p>
                </div>
            </a>
            <a href="">
                <div>
                    <p class="centerText tableIndex">+</p>
                </div>
            </a>
        </div>
        <c:forEach items="${practices}" var="practice">
            <a href="/admin/practice/<c:out value='${practice.getId()}'/>">
                <div class="practiceTableItem">
                    <p>
                        <c:out value="${practice.title}" />
                    </p>
                </div>
            </a>
        </c:forEach>
    </div>
    <div class="practiceDetails">
        <c:choose>
            <c:when test="${practice.getId() != null}">
            </c:when>
            <c:otherwise>
                <p class="inspire">KEEP <br> CALM <br> AND <br> BREATHE</p>
            </c:otherwise>
        </c:choose>
    </div>
    <img src="/imgs/site/splash.png" class="splash" />
</div>
</div>
</body>
</html>