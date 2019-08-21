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
    <link rel="stylesheet" type="text/css" href="/css/admin/node.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin/table.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin/modal.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <title>Location Manager</title>
</head>
<body>
<div class="container">
<div class="locationGrid">
    <div class="adminNav">
        <a href="/"><div class="navItem">
            <p>M</p>
        </div></a>
        <a href="/admin/node"><div class="navItem">
            <p>L</p>
        </div></a>
        <a href="/admin/practice"><div class="navItem">
            <p>P</p>
        </div></a>
        <a href=""><div class="navItem">
            <p>U</p>
        </div></a>
        <a href=""><div class="navItem">
            <p>L</p>
        </div></a>
    </div>
    <div class="locationTable">
        <div class="locationTableHead">
            <a href="/admin/node"><div>
                <p class="centerText tableIndex">Stats</p>
            </div></a>
            <a href="/admin/createNode"><div>
                <p class="centerText tableIndex">+</p>
            </div></a>
        </div>
        <c:forEach items="${nodes}" var="node">
            <a href="/admin/node/<c:out value='${node.getId()}'/>"><div class="locationTableItem">
                <img src="/imgs/site/<c:out value='${node.theme}'/>.png"/>
                <p><c:out value="${node.title}" /></p>
            </div></a>
        </c:forEach>
    </div>
    <div class="locationDetails">
        <c:choose>
            <c:when test="${node.getId() != null}">
                <div class="location manageFeedStyle">
                    <h1 class="locationTitle"><c:out value="${node.title}" /></h1>
                    <h3 class="locationTheme"><c:out value="${node.theme}" /></h3>
                    <img src="/imgs/<c:out value='${node.photo}' />" class="locationImage">
                    <p class="locationDescription"><c:out value="${node.description}" /></p>
                    <div class="locationUrl">
                        <p>Url: <a href="<c:out value='${node.navigationUrl}' />">
                                <c:out value="${node.navigationUrl}" /></a>
                        </p>
                    </div>
                    <div class="latlon">
                        <p>Latitude: <c:out value="${node.latitude}" /></p>
                        <p>longitude: <c:out value="${node.longitude}" /></p>
                    </div>
                    <div class="editLocation">
                        <button class="deleteLocationButton" id="deleteLocationButton">Delete</button>
                        <button class="editLocationButton" id="updateLocationButton">Edit</button>
                    </div>
                </div>
                <div class="managePractices manageFeedStyle">
                    <div class="practiceTable">
                        <h2 class="centerText">All Practices</h2>
                        <table class="content-table center">
                            <thead>
                                <tr>
                                    <th>Practices</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${practices}" var="practice">
                                    <tr>
                                        <td>
                                            <c:out value="${practice.title}" />
                                        </td>
                                        <td>
                                            <a href="/admin/addPracticeToNode/${practice.getId()}">Add</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="addedPracticeTable">
                        <h2 class="centerText">Practices Added</h2>
                        <table class="content-table center">
                            <thead>
                                <tr>
                                    <th>Practices</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${nodesPractices}" var="nodesPractice">
                                    <tr>
                                        <td>
                                            <c:out value="${nodesPractice.title}" />
                                        </td>
                                        <td>
                                            <a href="/admin/removeNodesPractices/${nodesPractice.getId()}" >Remove</a><br>
                                            <a href="/admin/updateNodesPractices/${nodesPractice.getId()}">Update</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="toPractices centerText">
                        <form action="" method="GET">
                            <input type="submit" value="To Practices" class="toPracticesButton">
                        </form>
                    </div>
                </div>
                <div class="modalHolder">
                    <div id="updateLocationModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <h1 class="centerText">Update Location</h1>
                            <p>
                                <form:errors path="updateNode.*" />
                            </p>
                            <form:form method="PUT" action="/admin/updateNode/${node.getId()}" modelAttribute="updateNode" class="form">
                                <p>
                                    <form:label path="title">Title:</form:label>
                                    <form:input path="title" value="${node.title}" />
                                </p>
                                <p>
                                    <form:label path="theme">Theme:</form:label>
                                    <form:input path="theme" value="${node.theme}" />
                                </p>
                                <p>
                                    <form:label path="description">Description</form:label>
                                    <form:input path="description" value="${node.description}" />
                                </p>
                                <p>
                                    <form:label path="navigationUrl">Navigation Url</form:label>
                                    <form:input path="navigationUrl" value="${node.navigationUrl}" />
                                </p>
                                <p>
                                    <form:label path="photo">Photo:</form:label>
                                    <form:input path="photo" value="${node.photo}" />
                                </p>
                                <p>
                                    <form:label path="latitude">Latitude:</form:label>
                                    <form:input path="latitude" value="${node.latitude}" />
                                </p>
                                <p>
                                    <form:label path="longitude">Longitude:</form:label>
                                    <form:input path="longitude" value="${node.longitude}" />
                                </p>
                                <input type="submit" value="Update" />
                            </form:form>
                        </div>
                    </div>
                    <div id="deleteLocationModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <h1 class="centerText">Delete Location</h1>
                            <p>Are you sure you want to delete this location?</p>
                            <form:form method="DELETE" action="/admin/deleteNode/${node.getId()}" class="form">
                                <input type="submit" value="Yes Delete this location" />
                            </form:form>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:when test="${createNode != null}">
                <div class="manageFeedStyle">
                    <h1 class="centerText">Create <br> Location</h1>
                    <p>
                        <form:errors path="node.*" />
                    </p>
                    <form:form method="POST" action="/admin/createNewNode" modelAttribute="createNode" class="form">
                        <p>
                            <form:label path="title">Title:</form:label>
                            <form:input path="title" />
                        </p>
                        <p>
                            <form:label path="theme">Theme:</form:label>
                            <form:input path="theme" />
                        </p>
                        <p>
                            <form:label path="description">Description:</form:label>
                            <form:textarea path="description" />
                        </p>
                        <p>
                            <form:label path="navigationUrl">Navigation Url</form:label>
                            <form:input path="navigationUrl" />
                        </p>
                        <p>
                            <form:label path="photo">Photo:</form:label>
                            <form:input path="photo" />
                        </p>
                        <p>
                            <form:label path="latitude">Latitude:</form:label>
                            <form:input path="latitude" />
                        </p>
                        <p>
                            <form:label path="longitude">Longitude:</form:label>
                            <form:input path="longitude" />
                        </p>
                        <input type="submit" value="Submit" />
                    </form:form>
                </div>
                                    
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
<script src="/js/node.js"></script>

</html>