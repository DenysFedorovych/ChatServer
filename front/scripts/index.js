function login() {
    let newSocket = new WebSocket("ws://echo.websocket.org");
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const logIn = {
        type: "login",
        username: username,
        password: password
    };

    newSocket.onopen = function (event) {
        console.log("CONNECTION");

        newSocket.send(JSON.stringify(logIn));
    }

    newSocket.onclose = function (event) {
        alert("CONNECTION CLOSED");
    }

    newSocket.onmessage = function (event) {
        const message = event.data;
        message.id;
        alert(JSON.parse(event.data));
    }

    newSocket.onerror = function (event) {
        alert(event.code + "ERROR");
    }
}

function registration() {
    const pass = document.getElementById("password").value;
    const checkPass = document.getElementById("checkpass").value;
    let regIn;
    if (pass.length < 4 || pass === "") {
        alert("LOH");
    } else if (pass === checkPass) {
        let newSocket = new WebSocket("ws://echo.websocket.org");
        regIn = {
            type: "registration",
            firstName: document.getElementById("fname").value,
            lastName: document.getElementById("lname").value,
            username: document.getElementById("username").value,
            email: document.getElementById("email").value,
            password: pass
        };

        newSocket.onopen = function (event) {
            console.log("CONNECTION");

            newSocket.send(JSON.stringify(regIn));
        }

        newSocket.onmessage = function (ev) {
            let message = JSON.parse(ev.data);
            alert(message.type + " " + message.username + " " + message.firstName);
            newSocket.close();
            setTimeout(() => {
                window.location.replace("../html/main.html")
            }, 1000);
        }

        newSocket.onclose = function (ev) {
            console.log("CLOSED");
        }
    } else {
        alert("Password not equals to checked");
    }
}