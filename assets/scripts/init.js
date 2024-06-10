
// After page load iniiate these functions.
function init() {

    setInterval(UpdateClock, 1000);
    regFoucs();

    const jsonData = {
        "data": {
            "id": "tempID",
            "type": "",
            "status": "live",
            "date": "2024-6-30",
            "unixtimestamp": "11",
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
    RenderEntry(jsonData);
    RenderEntry(jsonData);
}