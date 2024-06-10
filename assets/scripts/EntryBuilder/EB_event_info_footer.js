
// Constructs the footer for a entery.
function EB_event_info_footer(jsonData) {
    
    const eventDiv = document.createElement("div");
    eventDiv.classList.add("event-info-footer");
    
    const location = document.createElement("p");
    const locationtxt = document.createTextNode("Location");
    location.classList.add("event-info-footer-text");
    location.append(locationtxt);
    eventDiv.append(location);
    
    
    const excatDate = document.createElement("p");
    const exactDateTxt = document.createTextNode("0/0/0");
    excatDate.classList.add("event-info-footer-text");
    excatDate.append(exactDateTxt);
    eventDiv.append(excatDate);
    
    
    const posted = document.createElement("p");
    const postedInfo = document.createTextNode("Edited By Matt on 0/0/0");
    posted.classList.add("event-info-footer-text");
    posted.append(postedInfo);
    eventDiv.append(posted);
    
    
    return eventDiv;
}