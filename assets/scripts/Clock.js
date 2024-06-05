
// Update the clock in the header to display time and date.
function UpdateClock() {

    // Set current time
    let datetime = new Date();
    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    let typeOfSpacer = " ";

    let dateNumber = datetime.getDate();
    let dateMonth = datetime.getMonth();

    let hrs = datetime.getHours();
    let mins = datetime.getMinutes();
    let seconds = datetime.getSeconds();
    let ampm = hrs >= 12 ? "pm" : "am";
    mins = mins < 10 ? '0' + mins : mins;

    if (hrs > 12) {

        hrs = hrs - 12;
    }

    switch (dateNumber) {
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

    const finalDateString = hrs + ":" + mins + ampm + " " + dateNumber + typeOfSpacer + months[dateMonth];

    document.getElementById("header-timedate").innerText = finalDateString;
}