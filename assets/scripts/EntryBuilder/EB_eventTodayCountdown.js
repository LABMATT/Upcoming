// Event today countdown
function EB_eventTodayCountdown(jsonData) {
    
    // Create Div for the eventToday-countdown
    const eventDiv = document.createElement("div");
    eventDiv.classList.add("eventToday-countdown");


    // Creates the word IN at the top of the countdown.
    const countdownIN = document.createElement("p");
    const countdownINtxt = document.createTextNode("IN");
    countdownIN.classList.add("subevent-text-complmenty");
    countdownIN.append(countdownINtxt);
    eventDiv.append(countdownIN);
    
    // Create number of days till event.
    const subEventTextMain = document.createElement("h2");
    const subEventTextMainText = document.createTextNode("0");
    subEventTextMain.classList.add("subevent-text-main");
    subEventTextMain.append(subEventTextMainText);
    eventDiv.append(subEventTextMain);

    
    // Creates the word "days" at the bottom of the countdown.
    const countdownDays = document.createElement("p");
    const countdowndDaystext = document.createTextNode("Days");
    countdownDays.classList.add("subevent-text-complmenty");
    countdownDays.append(countdowndDaystext);
    eventDiv.append(countdownDays);

    return eventDiv;
}