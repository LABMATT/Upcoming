
// After page load iniiate these functions.
function init() {

    setInterval(UpdateClock, 1000);
    regFoucs();

    const jsonData = {
        "data": {
            "id": "idone",
            "type": "",
            "status": "live",
            "date": "2024-6-11",
            "unixtimestamp": "11",
            "title": "Test Entry",
            "time": "8am - 9pm",
            "locationTitle": "Mernda cfa",
            "locationAdress": "79 shooters road, MERNDA 3754",
            "lastupdated": "6/6/6",
            "author": "Matthew Lewington",
            "edited": "Posted By Matthew Lewington",
            "text": "This is text"
        }
    };

    const jsonData2 = {
        "data": {
            "id": "idtwo",
            "type": "",
            "status": "live",
            "date": "2024-6-12",
            "unixtimestamp": "12",
            "title": "Test Entry",
            "time": "8am - 9pm",
            "locationTitle": "Mernda cfa",
            "locationAdress": "79 shooters road, MERNDA 3754",
            "lastupdated": "6/6/6",
            "author": "Matthew Lewington",
            "edited": "Posted By Matthew Lewington",
            "text": "This is text"
        }
    };

    const jsonData3 = {
        "data": {
            "id": "idthree",
            "type": "",
            "status": "cancel",
            "date": "2024-6-13",
            "unixtimestamp": "11",
            "title": "Test Entry",
            "time": "8am - 9pm",
            "locationTitle": "Mernda cfa",
            "locationAdress": "79 shooters road, MERNDA 3754",
            "lastupdated": "6/6/6",
            "author": "Matthew Lewington",
            "edited": "Posted By Matthew Lewington",
            "text": "This is text"
        }
    };

    const jsonData4 = {
        "data": {
            "id": "idthree",
            "type": "",
            "status": "",
            "date": "2024-6-14",
            "unixtimestamp": "11",
            "title": "Test Entry",
            "time": "8am - 9pm",
            "locationTitle": "Mernda cfa",
            "locationAdress": "79 shooters road, MERNDA 3754",
            "lastupdated": "6/6/6",
            "author": "Matthew Lewington",
            "edited": "Posted By Matthew Lewington",
            "text": "This is text"
        }
    };



    RenderEntry(jsonData);
    RenderEntry(jsonData2);
    RenderEntry(jsonData3);
    RenderEntry(jsonData4);
}