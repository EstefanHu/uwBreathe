var modal = document.getElementById("createLocationModal");
var btn = document.getElementById("createLocationButton");
var span = document.getElementsByClassName("close")[0];
var modalUpdate = document.getElementById("updateLocationModal");
var btnUpdate = document.getElementById("updateLocationButton");
var spanUpdate = document.getElementsByClassName("close")[1];


btn.onclick = function() {
    modal.style.display = "block";
}
span.onclick = function() {
    modal.style.display = "none";
}
window.onclick = function(e) {
    if (e.target == modal) {
        modal.style.display = "none";
    } 
    if (e.target == modalUpdate) {
        modalUpdate.style.display = "none";
    }
}
btnUpdate.onclick = function () {
    modalUpdate.style.display = "block";
}
spanUpdate.onclick = function () {
    modalUpdate.style.display = "none";
}