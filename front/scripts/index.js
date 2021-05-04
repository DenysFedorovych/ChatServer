
function login() {
    let newSocket = new WebSocket("ws://echo.websocket.org");
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    let logIn = {
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
    const firstName = document.getElementById("fname").value;
    const lastName = document.getElementById("lname").value;
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const pass = document.getElementById("password").value;
    const checkPass = document.getElementById("checkpass").value;

    let regIn = {
        firstName: firstName,
        lastName: lastName,
        username: username,
        email: email,
        password: pass,
        checkPass: checkPass
    };

    axios.post('http://localhost:8080', regIn).then((response) => {
        console.log(response.data);
        if (response.status >= 200 && response.status < 300) {
            console.log('registration good');
            setTimeout(50000);
            window.location = '..\\html\\main.html';
        }
    }, (error) => {
        console.log(error);
    });
}