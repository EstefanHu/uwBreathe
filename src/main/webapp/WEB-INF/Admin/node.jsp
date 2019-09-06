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
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans|Encode+Sans|Josefin+Sans" />
    <title>Location Manager</title>
</head>
<body>
<div class="container">
<div class="adminGrid">
    <div class="adminNav">
        <a href="/"><div class="navItem">
            <p>M</p>
        </div></a>
        <a href="/admin/"><div class="navItem">
            <p>S</p>
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
    <div class="infoTable">
        <div class="infoTableHead">
            <a href="/admin/createNode"><div>
                <p class="centerText tableIndex">+</p>
            </div></a>
        </div>
        <c:forEach items="${nodes}" var="node">
            <a href="/admin/node/<c:out value='${node.getId()}'/>"><div class="infoTableItem">
                <img src="/imgs/site/<c:out value='${node.theme}'/>.png"/>
                <p><c:out value="${node.title}" /></p>
            </div></a>
        </c:forEach>
    </div>
    <div class="details">
        <c:choose>
            <c:when test="${currentNode != null}">
            <div class="manageFeedStyle">
            <div class="location ">
                    <h1 class="locationTitle"><c:out value="${currentNode.title}" /></h1>
                    <h3 class="locationTheme"><c:out value="${currentNode.theme}" /></h3>
                    <img src="/imgs/<c:out value='${currentNode.photo}' />" class="locationImage">
                    <p class="locationDescription"><c:out value="${currentNode.description}" /></p>
                    <div class="locationUrl">
                        <p>Url: <a href="<c:out value='${currentNode.navigationUrl}' />">
                                <c:out value="${currentNode.navigationUrl}" /></a>
                        </p>
                    </div>
                    <div class="latlon">
                        <p>Latitude: <c:out value="${currentNode.latitude}" /></p>
                        <p>longitude: <c:out value="${currentNode.longitude}" /></p>
                    </div>
                    <div class="editLocation">
                        <button class="deleteLocationButton" id="deleteLocationButton">Delete</button>
                        <button class="editLocationButton" id="updateLocationButton">Edit</button>
                    </div>
                </div>
                <div class="managePractices ">
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
                            <p>
                                <form:errors path="updateNode.*" />
                            </p>
                            <form:form method="PUT" action="/admin/updateNode/${currentNode.getId()}" modelAttribute="updateNode" class="form">
                                <h1 class="centerText">Update Location</h1>
                                <p>
                                    <form:label path="title">Title</form:label>
                                    <form:input path="title" value="${currentNode.title}" />
                                </p>
                                <p>
                                    <form:label path="theme">Theme</form:label>
                                    <form:select path="theme">
                                        <c:choose>
                                            <c:when test="${currentNode.theme.equals('Creative')}">
                                                <option selected value="Creative">Be Creative</option>
                                            </c:when>
                                            <c:when test="${currentNode.theme.equals('Generative')}">
                                                <option selected value="Generative">Personal Visualization</option>
                                            </c:when>
                                            <c:when test="${currentNode.theme.equals('Stillness')}">
                                                <option selected value="Stillness">Relax and Restore</option>
                                            </c:when>
                                            <c:when test="${currentNode.theme.equals('Relational')}">
                                                <option selected value="Relational">Restoring Through Others</option>
                                            </c:when>
                                            <c:when test="${currentNode.theme.equals('Movement')}">
                                                <option selected value="Movement">Wake Up Your Body</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option selected value="Ritual">Habitual Reflection</option>
                                            </c:otherwise>
                                        </c:choose>
                                        <option value="Creative">Be Creative</option>
                                        <option value="Generative">Personal Visualization</option>
                                        <option value="Stillness">Relax and Restore</option>
                                        <option value="Relational">Restoring Through Others</option>
                                        <option value="Movement">Wake up Your Body</option>
                                        <option value="Ritual">Habitual Reflection</option>
                                    </form:select>
                                </p>
                                <p>
                                    <form:label path="navigationUrl">Navigation URL</form:label>
                                    <form:input path="navigationUrl" value="${currentNode.navigationUrl}" />
                                </p>
                                <p>
                                    <form:label path="latitude">Latitude</form:label>
                                    <form:input path="latitude" value="${currentNode.latitude}" />
                                </p>
                                <p>
                                    <form:label path="longitude">Longitude</form:label>
                                    <form:input path="longitude" value="${currentNode.longitude}" />
                                </p>
                                <p>
                                    <form:label path="photo">Photo</form:label>
                                    <img src="/imgs/<c:out value='${currentNode.photo}' />" class="locationImage">
					        		<form:input path="photo" type = "file"/>
                                </p>
                                <p>
                                    <form:label path="description">Description</form:label>
                                    <form:textarea path="description" value="${currentNode.description}" />
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
                            <form:form method="DELETE" action="/admin/deleteNode/${currentNode.getId()}" class="form">
                                <input type="submit" value="Yes Delete this location" />
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            </c:when>
            <c:when test="${createNode != null}">
                <div class="manageFeedStyle">
                    <p>
                        <form:errors path="createNode.*" />
                    </p>
                    <form:form method="POST" action="/admin/createNewNode" modelAttribute="createNode" class="form">
                        <h1 class="centerText">Create Location</h1>
                        <p>
                            <form:label path="title">Title</form:label>
                            <form:input path="title" />
                        </p>
                        <p>
                            <form:label path="theme">Theme</form:label>
                            <form:select path="theme">
                                <option disabled selected value>--</option>
                                <option value="Creative">Be Creative</option>
                                <option value="Generative">Personal Visualization</option>
                                <option value="Stillness">Relax and Restore</option>
                                <option value="Relational">Restoring Through Others</option>
                                <option value="Movement">Wake up Your Body</option>
                                <option value="Ritual">Habitual Reflection</option>
                            </form:select>
                        </p>
                        
                        <p>
                            <form:label path="navigationUrl">Navigation URL</form:label>
                            <form:input path="navigationUrl" />
                        </p>
                        
                        <p>
                            <form:label path="latitude">Latitude</form:label>
                            <form:input path="latitude" />
                        </p>
                        <p>
                            <form:label path="longitude">Longitude</form:label>
                            <form:input path="longitude" />
                        </p>
                        <p>
                            <form:label path="photo">Photo</form:label>
					        <form:input path="photo" type = "file"/>
                        </p>
                        <p>
                            <form:label path="description">Description</form:label>
                            <form:textarea path="description" />
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