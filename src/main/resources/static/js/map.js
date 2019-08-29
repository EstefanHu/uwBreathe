var mymap = L.map('mapid', {zoomControl: false}).setView([47.65595008733427, -122.30885982513426], 15);
L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoiZXN0ZWZhbjA3NCIsImEiOiJjanozbm83OXUwNHRqM25tcm84MHYxd3cyIn0.MSuA8qUuoo1A2aWOcXI5ng', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    id: 'mapbox.streets',
    accessToken: 'your.mapbox.access.token'
}).addTo(mymap);
new L.Control.Zoom({ position: 'topright' }).addTo(mymap);
