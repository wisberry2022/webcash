var fs = require('fs');

var content;
// 비동기적
fs.readFile('ex01.js', function (err, data) {
  content = data.toString('utf-8');
})

console.log(content);
// 동기적
// var msg = fs.readFileSync("ex02.js", 'utf-8');
// console.log(msg);