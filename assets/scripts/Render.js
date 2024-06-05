// Renders an entry recived by ther server.
function RenderEntry(jsonData) {

    const entryID = "eventEntry_" + jsondata.data.id;

    if (jsonData.entry !== "" || jsonData.entry !== null) {

        // Create Div for the event
        const eventDiv = document.createElement("div");
        eventDiv.classList.add("event");
        eventDiv.id = entryID;

        // Sets up a DIV that displays date and day.
        const eventToday_date = EB_eventTodayDate(jsonData);

        // Add event to main event list.
        const eventToday_info = EB_eventTodayInfo(jsonData);

    }
}