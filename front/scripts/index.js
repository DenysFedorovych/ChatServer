function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    let logIn = {
        login: username,
        password: password
    };

    axios.post("http://localhost:8080/login/auth",logIn)
        .then((response) => {
        if(response.status === 200) {
            //document.location = "..\\html\\chatwindow.html";
            document.location = "http://localhost:8080/chatwindow";
            document.cookie = "token="+response.headers.getAttribute("Bearer");
        }
    }, (error) => {
        console.log(error);
        window.location = '..\\html\\NotFound.html';
    });
}

function registration() {
    const firstName = document.getElementById("fname").value;
    const lastName = document.getElementById("lname").value;
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const pass = document.getElementById("password").value;
    const checkPass = document.getElementById("checkpass").value;
    const headers = {'Content-Type': 'application/json'};

    let regIn = {
        firstName: firstName,
        lastName: lastName,
        login: username,
        password: pass,
        confirmPassword: checkPass,
        email: email,
        phone: "3242342"
    };

    axios.post('http://localhost:8080/login/registration', regIn)
        .then((response) => {
        console.log(response.data);
        if (response.status >= 200 && response.status < 300) {
            console.log('registration good');
            setTimeout(50000);
            document.location = '..\\html\\main.html';
        }
    }, (error) => {
        console.log(error);
    });
}