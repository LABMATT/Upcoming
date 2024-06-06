
// After page load iniiate these functions.
function init() {

    setInterval(UpdateClock, 1000);
    regFoucs();

    const jsonData = {
        "data": {
            "id": "tempID",
            "status": "live",
            "date": "5/5/5",
            "title": "Test Entry",
            "time": "9am",
            "locationTitle": "Mernda cfa",
            "locationAdress": "79 shooters road",
            "lastupdated": "6/6/6",
            "author": "Matthew Lewington",
            "edited": "6/6/6",
            "text": "This is text"
        }
    };

    RenderEntry(jsonData);
}