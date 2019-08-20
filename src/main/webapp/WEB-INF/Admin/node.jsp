<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="/css/admin/admin.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin/node.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin/table.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin/modal.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <title>Location Manager</title>
</head>

<body>
    <div class="container">
        <div class="adminNav">
            <a href="/">
                <p class="navItem centerText firstNavItem">Map</p>
            </a>
            <div class="primaryNav">
                <a href="">
                    <p class="navItem centerText">Location</p>
                </a>
                <a href="">
                    <p class="navItem centerText">Practice</p>
                </a>
                <a href="">
                    <p class="navItem centerText">User</p>
                </a>
            </div>
            <a href="">
                <p class="navItem centerText lastNavItem">Logout</p>
            </a>
        </div>
        <div class="locationGrid">
            <div class="locationTable">
                <table class="content-table">
                    <thead>
                        <tr>
                            <th>Manager</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Paccar Hall</td>
                            <td><a href="">Edit</a></td>
                        </tr>
                        <tr>
                            <td>The Hub</td>
                            <td><a href="">Edit</a></td>
                        </tr>
                        <tr>
                            <td>Rainer Vista</td>
                            <td><a href="">Edit</a></td>
                        </tr>
                        <tr>
                            <td>Grieg Garden</td>
                            <td><a href="">Edit</a></td>
                        </tr>
                        <tr>
                            <td>IMA</td>
                            <td><a href="">Edit</a></td>
                        </tr>
                    </tbody>
                </table>
                <button class="createNew" id="createLocationButton">Create Location</button>
            </div>
            <div class="locationDetails">
                <div class="locationStatistics manageFeedStyle">
                    <h1 class="centerText">Statistics about Locations</h1>
                </div>
                <div class="location manageFeedStyle">
                    <h1 class="locationTitle">Paccar Hall</h1>
                    <h3 class="locationTheme">Move Your Body</h3>
                    <img src="/imgs/paccar.png" class="locationImage">
                    <p class="locationDescription">This location is about as good as it gets, really just a fantastic
                        location to sit and look at the window nothing other than the window only the window the window
                        is the world</p>
                    <div class="locationUrl">
                        <p>Url: <a
                                href="https://www.google.com/maps/place/PACCAR+Hall/@47.6591406,-122.310787,17z/data=!3m1!4b1!4m5!3m4!1s0x5490148c7ff84a3f:0x8a58dcfd31224abd!8m2!3d47.6591406!4d-122.3085982">
                                www.google.com/maps/place/PACCAR+Hall/@47.6591406,-122.310787,17z/data=!3m1!4b1!4m5!3m4!1s0x5490148c7ff84a3f:0x8a58dcfd31224abd!8m2!3d47.6591406!4d-122.3085982</a>
                        </p>
                    </div>
                    <div class="latlon">
                        <p>Latitude: 47.098743</p>
                        <p>longitude: -122.243562</p>
                    </div>
                    <div class="editLocation">
                        <button class="editLocationButton" id="updateLocationButton">Edit Location</button>
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
                                            <form:form method="DELETE" action="/admin/removeNodesPractices/${nodesPractice.getId()}"
                                                modelAttribute="PracticesNode">
                                                <input type="submit" value="Remove from Node" />
                                            </form:form>
                                            <a href="/admin/updateNodesPractices/${nodesPractice.getId()}">Update</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="toPractices centerText">
                        <form action="" method="GET">
                            <input type="submit" value="Edit Practices" class="toPracticesButton">
                        </form>
                    </div>
                </div>
                <div class="photoManager manageFeedStyle">
                </div>
            </div>
            <img src="/imgs/site/splash.png" class="splash" />
        </div>
        <div id="createLocationModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h1 class="centerText">Create New Location</h1>
                <p>
                    <form:errors path="node.*" />
                </p>
                <form:form method="POST" action="createNewNode" modelAttribute="node" class="creationForm">
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
                        <form:input path="description" />
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
        </div>
        <div id="updateLocationModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h1 class="centerText">Update Location</h1>
                <p>
                    <form:errors path="updateNode.*" />
                </p>
                <form:form method="PUT" action="/admin/updateNode/${node.getId()}" modelAttribute="updateNode" class="creationForm">
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
</body>
<script src="/js/node.js"></script>

</html>