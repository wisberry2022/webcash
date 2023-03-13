var http = require('http');
var fs = require('fs');
var url = require('url');

var cb = function () {
  console.log('success');
}

var serv = http.createServer(function (req, res) {
  // var msg = fs.readFileSync('./ex22.html');
  res.setHeader('content-type', 'text/html; charset=utf-8');
  fs.readFile('./ex22.html', function (err, data) {
    res.write(data);
    res.end();
  })
});

serv.listen(3000, function () {
  console.log('server start');
});