// Create WebSocket connection.
const socket = new WebSocket("wss://192.168.1.102:433");

// Connection opened
socket.addEventListener("open", (event) => {

    //socket.send("Hello Server!");
    socket.send(JSON.stringify(new RequestLogs(globalAutho)));
});

// Listen for messages
socket.addEventListener("message", (event) => {

    // Send the data to be interpated.
    interpreter(event.data);
});

// On connection clsoed then produce error.
socket.addEventListener("close", (event) => {

    console.log("Websocket Connection Closed.")

    const wsclose = {"command": "error", "message": "Websocket Connection Lost"}

    error(wsclose);
});

// On connection lost due to error.
socket.addEventListener("error", (event) => {

    console.log("Websocket Connection Error." + JSON.stringify(event))

    const wsclose = {"command": "error", "message": "Websocket Connection Error."}
    
    document.getElementById("loginingMessage").style.display = "block";
    document.getElementById("loginingMessage").style.color = "red";
    document.getElementById("loginingMessage").innerText = "Error connecting to server";
});