
// Constructs the footer for a entery.
function EB_event_info_footer(jsonData) {
    
    // Creates A main div for the footer.
    const eventDiv = document.createElement("div");
    eventDiv.classList.add("event-info-footer");
    

    // Creates the First location tag
    const location = document.createElement("p");
    const locationtxt = document.createTextNode(jsonData.data.locationAdress);
    location.classList.add("event-info-footer-text");
    location.append(locationtxt);
    eventDiv.append(location);
    
    
    // Creates a tag for the exact date
    const excatDate = document.createElement("p");
    const exactDateTxt = document.createTextNode(jsonData.data.date);
    excatDate.classList.add("event-info-footer-text");
    excatDate.append(exactDateTxt);
    eventDiv.append(excatDate);
    
    
    // Creates tag for posted/edited
    const posted = document.createElement("p");
    const postedInfo = document.createTextNode(jsonData.data.edited);
    posted.classList.add("event-info-footer-text");
    posted.append(postedInfo);
    eventDiv.append(posted);
    
    
    return eventDiv;
}