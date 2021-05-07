const status = document.getElementById('status');
const messages = document.getElementById('messages');
const form = document.getElementById('form');
const input = document.getElementById('input');

let onFocusTrue = false;

const ws = new WebSocket('ws://localhost:8080/chat');

function setStatus(value) {
    status.innerHTML = value;
}

function printMessage(value) {
    const div = document.createElement('div');
    console.log(value);
    div.innerHTML = value;
    messages.appendChild(div);
}

function sendMsg() {
    let env = JSON.stringify({topic: 'messages', payload: input.value});
    //printMessage(input.value);
    ws.send(env);
    input.value = '';
}

input.onfocus = function() {
    onFocusTrue = true;
}

function sendStartEnvelope() {
    let env = JSON.stringify({topic: 'auth', payload: localStorage.getItem("token")});
    ws.send(env);
}

ws.onopen = () => {
    sendStartEnvelope();
    setStatus('DOGO ONLINE');
}

ws.onclose = () => setStatus('DOGO OUT');

ws.onmessage = response => printMessage(response.data);