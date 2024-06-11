function EB_eventTodayDate(jsonData, daysTillEvent) {
    
    let colourType = "event-date";

    if(daysTillEvent === 0) {

        colourType = "eventToday-date";
    }

    if(jsonData.data.status === "cancel") {

        colourType = "eventCanceled-date";
    }

    // Works out the maths inorder to formate the event date section.
    const daysOfWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    const monthsOfYear = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    const date = new Date(jsonData.data.date);
    const dayOfWeek = daysOfWeek[date.getDay()];
    const dayOfMonth = date.getDate();
    const monthOfYear = monthsOfYear[date.getMonth()];

    let typeOfSpacer = "th";

    switch (dayOfMonth) {
        case 1:
            typeOfSpacer = "st ";
            break;
        case 2:
            typeOfSpacer = "nd ";
            break;
        case 3:
            typeOfSpacer = "rd ";
            break;
        default:
            typeOfSpacer = "th ";
            break;
    }


    // Create Div for the eventToday-date
    const eventTodayDate = document.createElement("div");
    eventTodayDate.classList.add(colourType);
    
    // Create p for the date
    const eventDayP = document.createElement("p");
    const day = document.createTextNode(dayOfWeek);
    eventDayP.classList.add("subevent-text-complmenty");
    eventDayP.append(day);
    eventTodayDate.append(eventDayP);
    
    // Create p for the date
    const eventNumber = document.createElement("h2");
    const number = document.createTextNode(dayOfMonth);
    eventNumber.classList.add("subevent-text-main");
    eventNumber.append(number);
    eventTodayDate.append(eventNumber);

    
    // Create p for the month
    const eventMonthP = document.createElement("p");
    const month = document.createTextNode(monthOfYear);
    eventMonthP.classList.add("subevent-text-complmenty");
    eventMonthP.append(month);
    eventTodayDate.append(eventMonthP);

    return eventTodayDate;
}