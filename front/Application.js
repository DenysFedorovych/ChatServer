const http = require('http');
const path = require('path');
const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const router = express.Router();
app.use(bodyParser.urlencoded({extended: false}));
app.use(express.static(__dirname));
const route = router.get('', (req, res,next)=>{
    res.sendFile(path.join(__dirname, 'html', 'main.html'));
});
// router.post('/post-username', (req, res, next)=>{
//     console.log('data: ', req.body.username);
//     res.send('<h1>'+req.body.username+'</h1>');
// });
module.exports = router;


app.use('',route);
app.use((req, res,next)=>{
    res.status(404).send('<h1> Page not found </h1>');
});
const server = http.createServer(app);
server.listen(8080);