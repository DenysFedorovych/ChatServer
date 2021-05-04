const http = require('http');
const path = require('path');
const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const router = express.Router();
app.use(bodyParser.urlencoded({extended: false}));
app.use(express.static(__dirname));
const main = router.get('', (req, res,next)=>{
    res.sendFile(path.join(__dirname, 'html', 'main.html'));
});
const register = router.get('', (req, res,next)=>{
    res.sendFile(path.join(__dirname, 'html', 'main.html'));
});
module.exports = router;
app.use('',main);
app.use((req, res,next)=>{
    res.status(404).send('<h1> Page not found </h1>');
});
const server = http.createServer(app);
server.listen(8080);