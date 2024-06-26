// Renders an entry recived by ther server.
function RenderEntry(jsonData, daysTillEvent) {

    console.log("Json" + jsonData);

    if (jsonData.data !== "" || jsonData.data !== null) {

        const entryID = "eventEntry_" + jsonData.data.id;
        console.log("ID IS: " + jsonData.data.id);


        // Creates the days till event. This then allows us to choose colours and set data in countdown.
        // This section does all the calculations for the countdown.
        const date = new Date(jsonData.data.date);
        const dateNow = new Date();
        let daysTillEvent = Math.abs(Math.round((dateNow.getTime() - date.getTime()) / (1000 * 3600 * 24))) + 1;
        let isPassed = false;

        if(dateNow.getTime() > date.getTime()) {

            daysTillEvent = Math.round((dateNow.getTime() - date.getTime()) / (1000 * 3600 * 24)) - 1;
            isPassed = true;
        }

        // If the date is the same then days to is 0
        if(date.getDate() === dateNow.getDate()) {

            daysTillEvent = 0;
        }


        console.log("ID: " + jsonData.data.id);
        console.log("Count: " + daysTillEvent);
        console.log(" ");


        // Create Div for the EVENT
        const eventDiv = document.createElement("div");
        eventDiv.classList.add("event");
        eventDiv.id = entryID;


        // Sets up a DIV that displays date and day.
        const eventToday_date = EB_eventTodayDate(jsonData, daysTillEvent);

        // Add event to main event list.
        const eventToday_info = EB_eventTodayInfo(jsonData, daysTillEvent);

        // Adds eventToday-countdown
        const eventToday_countdown = EB_eventTodayCountdown(jsonData, daysTillEvent, isPassed);


        // Add all events to the newly created Event Div.
        // Add newly created Event Div to the ListedEvents div/id.
        eventDiv.append(eventToday_date);
        eventDiv.append(eventToday_info);
        eventDiv.append(eventToday_countdown);
        document.getElementById("listedEvents").append(eventDiv);
    }
}