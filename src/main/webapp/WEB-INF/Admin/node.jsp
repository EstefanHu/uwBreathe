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
                                <tr>
                                    <td>Breathe</td>
                                    <td><a href="">Add</a></td>
                                </tr>
                                <tr>
                                    <td>Think</td>
                                    <td><a href="">Add</a></td>
                                </tr>
                                <tr>
                                    <td>Go for a Jog</td>
                                    <td><a href="">Add</a></td>
                                </tr>
                                <tr>
                                    <td>Try to Draw</td>
                                    <td><a href="">Add</a></td>
                                </tr>
                                <tr>
                                    <td>Dance</td>
                                    <td><a href="">Add</a></td>
                                </tr>
                                <tr>
                                    <td>Sing a Song</td>
                                    <td><a href="">Add</a></td>
                                </tr>
                                <tr>
                                    <td>Scream</td>
                                    <td><a href="">Add</a></td>
                                </tr>
                                <tr>
                                    <td>Fight Someone</td>
                                    <td><a href="">Add</a></td>
                                </tr>
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
                                <tr>
                                    <td>Breathe</td>
                                    <td><a href="">Remove</a></td>
                                </tr>
                                <tr>
                                    <td>Go for a Jog</td>
                                    <td><a href="">Remove</a></td>
                                </tr>
                                <tr>
                                    <td>Try to Draw</td>
                                    <td><a href="">Remove</a></td>
                                </tr>
                                <tr>
                                    <td>Sing a Song</td>
                                    <td><a href="">Remove</a></td>
                                </tr>
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
                <form method="POST" action="createNewNode" class="form">
                    <p>
                        <label path="title">Title:</label>
                        <input path="title" />
                    </p>
                    <p>
                        <label path="theme">Theme:</label>
                        <input path="theme" />
                    </p>
                    <p>
                        <label path="description">Description:</label>
                        <input path="description" />
                    </p>
                    <p>
                        <label path="navigationUrl">Navigation Url</label>
                        <input path="navigationUrl" />
                    </p>
                    <p>
                        <label path="photo">Photo:</label>
                        <input path="photo" />
                    </p>
                    <p>
                        <label path="latitude">Latitude:</label>
                        <input path="latitude" />
                    </p>
                    <p>
                        <label path="longitude">Longitude:</label>
                        <input path="longitude" />
                    </p>
                    <input type="submit" value="Submit" />
                </form>
            </div>
        </div>
        <div id="updateLocationModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h1 class="centerText">Update Location</h1>
                <form method="PUT" action="" class="form">
                    <p>
                        <p>
                            <label path="title">Title:</label>
                            <input path="title" value="Paccar Hall" />
                        </p>
                        <p>
                            <label path="theme">Theme:</label>
                            <input path="theme" value="Move Your Body" />
                        </p>
                        <p>
                            <label path="description">Description:</label>
                            <input path="description"
                                value="This location is about as good as it gets, really just a fantastic location to sit and look at the window nothing other than the window only the window the window is the world" />
                        </p>
                        <p>
                            <label path="navigationUrl">Navigation Url</label>
                            <input path="navigationUrl"
                                value="www.google.com/maps/place/PACCAR+Hall/@47.6591406,-122.310787,17z/data=!3m1!4b1!4m5!3m4!1s0x5490148c7ff84a3f:0x8a58dcfd31224abd!8m2!3d47.6591406!4d-122.3085982" />
                        </p>
                        <p>
                            <label path="photo">Photo:</label>
                            <input path="photo" value="paccar.png" />
                        </p>
                        <p>
                            <label path="latitude">Latitude:</label>
                            <input path="latitude" value="47.234562" />
                        </p>
                        <p>
                            <label path="longitude">Longitude:</label>
                            <input path="longitude" value="-122.23452345" />
                        </p>
                        <input type="submit" value="Submit" />
                    </p>
                </form>
            </div>
        </div>
</body>
<script src="/js/node.js"></script>

</html>