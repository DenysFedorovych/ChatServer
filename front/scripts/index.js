import axios from "axios";

function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    let logIn = {
        login: username,
        password: password
    };

    axios.get("http://localhost:8080/login/auth",logIn).then((response) => {
        if(response.status === 200) {
            document.location.href = "http://localhost:8080/chat";
            document.cookie = "token="+response.headers.getAttribute("Bearer");
        }
    })
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