const status = document.getElementById('status');
const messages = document.getElementById('messages');
const form = document.getElementById('form');
const input = document.getElementById('input');

let onFocusTrue = false;

const ws = new WebSocket('ws://localhost:8080');

function setStatus(value) {
    status.innerHTML = value;
}

function printMessage(value) {
    const li = document.createElement('div');
    li.innerHTML = value;
    messages.appendChild(li);
}

function sendMessageHttp() {
    http.open();
}

function sendMsg() {
    ws.send(input.value);
    input.value = '';
}

input.onfocus = function() {
    onFocusTrue = true;
}


function sendByEnter() {
    let key = 0;
    document.addEventListener('keypress', (ev) => {
        key = ev.code;
        console.log(key, onFocusTrue);
    })
    if (key === "Enter" && onFocusTrue === true) {
        ws.send(input.value);
        input.value = '';
    }
}

ws.onopen = () => setStatus('DOGO ONLINE');

ws.onclose = () => setStatus('DOGO OUT');

ws.onmessage = response => printMessage(response.data);