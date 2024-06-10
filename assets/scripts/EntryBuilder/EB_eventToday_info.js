// Constructs the main info section of an entry.
// Addes all elements and then outsources the footer to EB_event_info_footer
function EB_eventTodayInfo(jsonData) {
    
    // Create Div for the eventToday-Info
    const eventDiv = document.createElement("div");
    eventDiv.classList.add("eventToday-info");



    // Create the title text
    const eventTitle = document.createElement("h2");
    const eventTitletxt = document.createTextNode("Event Title");
    eventTitle.classList.add("event-info-header-text");
    eventTitle.append(eventTitletxt);
    eventDiv.append(eventTitle);


    // Create the time below the title text.
    const timeDiv = document.createElement("div");
    const timeText = document.createElement("p");
    const timeInfo = document.createTextNode("8am - 9am");
    timeText.classList.add("event-info-time");
    timeText.append(timeInfo);
    timeDiv.append(timeText);
    eventDiv.append(timeDiv);


    // Creates the info within an event.
    const eventInfoDiv = document.createElement("div");
    const eventinfoP = document.createElement("p");
    const eventInfoText = document.createTextNode("Event info data");
    eventInfoDiv.classList.add("event-info-text");
    eventinfoP.classList.add("event-info-text-data");
    eventinfoP.append(eventInfoText);
    eventInfoDiv.append(eventinfoP);
    eventDiv.append(eventInfoDiv);


    // Get the footer from EB_event_info_footer function.
    const eventInfoFooter = EB_event_info_footer();
    eventDiv.append(eventInfoFooter);

    return eventDiv;
}