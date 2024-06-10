// Renders an entry recived by ther server.
function RenderEntry(jsonData) {

    //jsonData = JSON.parse(jsonData);

    console.log("Json" + jsonData);

    if (jsonData.data !== "" || jsonData.data !== null) {

        const entryID = "eventEntry_" + jsonData.data.id;

        // Create Div for the EVENT
        const eventDiv = document.createElement("div");
        eventDiv.classList.add("event");
        eventDiv.id = entryID;


        // Sets up a DIV that displays date and day.
        const eventToday_date = EB_eventTodayDate(jsonData);

        // Add event to main event list.
        const eventToday_info = EB_eventTodayInfo(jsonData);

        // Adds eventToday-countdown
        const eventToday_countdown = EB_eventTodayCountdown(jsonData);


        // Add all events to the newly created Event Div.
        // Add newly created Event Div to the ListedEvents div/id.
        eventDiv.append(eventToday_date);
        eventDiv.append(eventToday_info);
        eventDiv.append(eventToday_countdown);
        document.getElementById("listedEvents").append(eventDiv);
    }
}