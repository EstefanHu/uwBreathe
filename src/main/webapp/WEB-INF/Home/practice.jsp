<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
        integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
        crossorigin="" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin/modal.css" />
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
            
            <h4>Notes from Students <span class="createComment" id="comment"><p>+</p></span></h4>
            <div class="commentHolder">
                <c:forEach items="${practice.getComments()}" var="comment">
                    <div class="heldComment">
                        <p>"<c:out value="${comment.content}"/>"</p>
                        <h5>-<c:out value="${comment.commenter}"/></h5>
                    </div>
                </c:forEach>
            </div>
            <div class="modalHolder">
                <div id="updateLocationModal" class="modal">
                    <div class="modal-content">
                        <span class="close">&times;</span>
                        <h1 class="centerText">Create comment</h1>
                        <p>
                            <form:errors path="updateNode.*" />
                        </p>
                        <form:form method="POST" action="/createComment" modelAttribute="createComment" class="form">
                            <p>
                                <form:label path="commenter">Name:</form:label>
                                <form:input path="commenter" />
                            </p>
                            <p>
                                <form:label path="content">Comment</form:label>
                                <form:textarea path="content"/>
                            </p>
                            <input type="submit" value="Comment" />
                        </form:form>
                    </div>
                </div>
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
    var modal = document.getElementById("updateLocationModal");
    var btn = document.getElementById("comment");
    var span = document.getElementsByClassName("close")[0];

    window.onclick = function(e) {
        if (e.target == modal) {
            modal.style.display = "none";
        }
    }
    btn.onclick = () => modal.style.display = "block";
    span.onclick = () => modal.style.display = "none";
</script>
</body>
</html>