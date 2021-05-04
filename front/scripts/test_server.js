const http = require('http');
const host = 'localhost';
const port = 8080;

const server = http.createServer(((req, res) => {
    if(req.method === 'OPTIONS') {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH,OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "DNT,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Range");
        res.setHeader("Access-Control-Max-Age", 1728000);
        res.setHeader("Content-Type", "text/plain; charset=utf-8");
        res.setHeader("Contetn-length", 0);
        res.writeHead(204);
        res.end();
    } else if(req.method === 'GET') {
        res.write('<html>');
        res.write('<head> <title> GET </title> </head>');
        res.write(' <body> Hello Tutorials Point </body>');
        res.write('</html>');
        res.end();
    } else if(req.method === 'POST') {
        res.statusCode = 200;
        res.end();
    }
    console.log(req.url, req.method, req. headers);

}))

server.listen(port, host);