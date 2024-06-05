
// Adds the name of the organization at the top.
function setup(jsonData) {
    
    document.getElementById("headderText").innerText = "Upcoming events at " + jsonData.data.organization;
}