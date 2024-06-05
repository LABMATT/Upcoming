function EB_eventTodayDate(jsonData) {
    
    // Create Div for the eventToday-date
    const eventDiv = document.createElement("div");
    eventDiv.classList.add("eventToday-date");
    
    // Create p for the date
    const eventDayP = document.createElement("p");
    const day = document.createTextNode(jsondata.data.date);
    eventDayP.classList.add("subevent-text-complmenty");
    eventDayP.append(day);
    eventDiv.append(eventDayP);
    
    // Create p for the date
    const eventNumber = document.createElement("h2");
    const number = document.createTextNode(jsondata.data.date);
    eventNumber.classList.add("subevent-text-main");
    eventNumber.append(number);
    eventDiv.append(eventNumber);

    
    // Create p for the month
    const eventMonthP = document.createElement("p");
    const month = document.createTextNode(jsondata.data.date);
    eventMonthP.classList.add("subevent-text-complmenty");
    eventMonthP.append(month);
    eventDiv.append(eventMonthP);
}