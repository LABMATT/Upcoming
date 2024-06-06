function EB_eventTodayDate(jsonData) {
    
    // Create Div for the eventToday-date
    const eventTodayDate = document.createElement("div");
    eventTodayDate.classList.add("eventToday-date");
    
    // Create p for the date
    const eventDayP = document.createElement("p");
    const day = document.createTextNode("Monday");
    eventDayP.classList.add("subevent-text-complmenty");
    eventDayP.append(day);
    eventTodayDate.append(eventDayP);
    
    // Create p for the date
    const eventNumber = document.createElement("h2");
    const number = document.createTextNode("16th");
    eventNumber.classList.add("subevent-text-main");
    eventNumber.append(number);
    eventTodayDate.append(eventNumber);

    
    // Create p for the month
    const eventMonthP = document.createElement("p");
    const month = document.createTextNode("April");
    eventMonthP.classList.add("subevent-text-complmenty");
    eventMonthP.append(month);
    eventTodayDate.append(eventMonthP);

    return eventTodayDate;
}