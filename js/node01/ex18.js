var fs = require("fs");

// fs.writeFileSync('temp03.txt', '세번째 파일 작성');

// fs.readFile('temp03.txt', function (err, data) {
//   console.log(err, data.toString());
// })

// fs.writeFile("temp04.txt", "네 번째 파일 작성", function () {
//   console.log('작성 완료~');
// });

// var msg = fs.readFileSync('temp04.txt', 'utf-8');
// console.log(msg);

fs.rename('temp04.txt', './js02/temp04.txt/', function (e) { });