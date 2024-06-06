// Event today countdown
function EB_eventTodayCountdown(jsonData) {
    
    // Create Div for the eventToday-countdown
    const eventDivCountdown = document.createElement("div");
    eventDivCountdown.classList.add("eventToday-countdown");
    
    // Create p for the date
    const subEventTextMain = document.createElement("h2");
    const subEventTextMainText = document.createTextNode(jsonData.data.date);
    subEventTextMain.classList.add("subevent-text-main");
    subEventTextMain.append(subEventTextMainText);
    eventDivCountdown.append(subEventTextMain);
    
    return eventDivCountdown;
}