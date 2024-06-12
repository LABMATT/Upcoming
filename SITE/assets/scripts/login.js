
// Send login request to the server.
function sendLogin() {

    document.getElementById("loginingMessage").style.display = "block";
}

// On login then hide the login box.
function switchLogin(displayLogin) {

    if (displayLogin) {

        document.getElementById("login").style.display = "flex";
        document.getElementById("MainContent").style.display = "none";
    } else {

        document.getElementById("login").style.display = "none";
        document.getElementById("MainContent").style.display = "flex";
    }
}


// Registers the action of focus and when you hit enter wiile thje login box is selected them ove down.
function regLoginEvents() {

    document.getElementById("loginOrgInput").focus();


    document.getElementById("loginOrgInput").addEventListener("keypress", (event) => {

        console.log("KeyDown");

        if (event.keyCode === 13) {

            document.getElementById("loginPinInput").focus();
        }
    });

    document.getElementById("loginPinInput").addEventListener("keypress", (event) => {

        if (event.keyCode === 13) {

            document.getElementById("loginButton").click();
        }
    });


    document.getElementById("loginButton").addEventListener("click", (event) => {

        switchLogin(false);
    });
}