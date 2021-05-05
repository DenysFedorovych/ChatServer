function login() {
    // let xhr = new XMLHttpRequest();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    let logIn = {
        login: username,
        password: password
    };

    //
    // xhr.open('POST', 'http://localhost:8080/login/auth', true);
    // xhr.setRequestHeader('Content-Type', 'application/json');
    // xhr.onreadystatechange = function () {
    //     if (xhr.readyState === 4 && xhr.status === 200) {
    //         result.innerHTML = this.responseText;
    //     }
    // };
    // xhr.send(JSON.stringify(logIn));
    // xhr.onload = function () {
    //     if(xhr.status >= 200 && xhr.status < 300) {
    //         // document.cookie = xhr.getResponseHeader('Set-Cookie');
    //         const hui = xhr.getResponseHeader('Set-Cookie');
    //         console.log(xhr.response);
    //         let buff = '';
    //         for (let i = 0; i < hui.length; i++) {
    //             if (hui.charAt(i) !== ';') {
    //                 buff += hui.charAt(i)
    //             }
    //         }
    //         console.log(buff);
    //         console.log(document.cookie);
    //         console.log('registration good');
    //         //document.location = "..\\html\\chatwindow.html";
    //     } else {
    //         console.log(xhr.statusText);
    //     }
    // }

    axios.post("http://localhost:8080/login/auth", logIn)
        .then((response) => {
            if (response.status >= 200 && response.status < 300) {
                //document.location = "http://localhost:8080/chat";
                document.cookie = response.data;
                console.log(response.data);
                document.location = "..\\html\\chatwindow.html";
            }
        }, (error) => {
            console.log(error);
            window.location = '..\\html\\NotFound.html';
        });
}

async function registration() {
    let xhr = new XMLHttpRequest();

    const firstName = document.getElementById("fname").value;
    const lastName = document.getElementById("lname").value;
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const pass = document.getElementById("password").value;
    const checkPass = document.getElementById("checkpass").value;

    let regIn = {
        firstName: firstName,
        lastName: lastName,
        login: username,
        password: pass,
        confirmPassword: checkPass,
        email: email,
        phone: "3242342"
    };

    xhr.open('POST', 'http://localhost:8080/login/registration', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            result.innerHTML = this.responseText;
        }
    };
    xhr.send(JSON.stringify(regIn));
    xhr.onload = function () {
        if(xhr.status >= 200 && xhr.status < 300) {
            console.log('registration good');
            document.location = '..\\html\\main.html';
        } else {
            console.log(xhr.statusText);
        }
    }

    // axios.post('http://localhost:8080/login/registration', regIn)
    //     .then((response) => {
    //         console.log(response.data);
    //         console.log('registration good');
    //         if (response.status >= 200 && response.status < 300) {
    //             console.log('registration good');
    //             setTimeout(50000);
    //             document.location = '..\\html\\main.html';
    //         }
    //     }, (error) => {
    //         console.log(error);
    //     });


}