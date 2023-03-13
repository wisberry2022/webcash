var express = require('express')
var app = express()
var ejs = require('ejs');
var f = express.static('js02');

// static
app.use(f);

// body-parser
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

// template
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/intro', function (req, res) {
  var arr = ['item1', 'item2', 'item3', 'item4'];
  var obj = { key1: "val1", key2: "val2" };
  res.render('intro', { msg: 'hello', arr: arr, obj: obj, date: new Date() });
});

// app.use('/', function (req, res, next) {
//   res.status(404);
//   res.send('<h1>ok page</h1>');
// })

// app.post('/dept', function (req, res) {
//   console.log(req.method, req.body);
//   res.status(200);
//   res.send('<h1>dept page(post)</h1>');
// });

// app.get('/dept/:deptno', function (req, res) {
//   console.log(req.method, req.params.deptno);
//   res.send('<h1>dept page(get)</h1>');
// });

// app.get('/dept', function (req, res) {
//   console.log(req.method, req.query.deptno);
//   res.send('<h1>dept page(get)</h1>');
// });

// app.post('/dept/:deptno', function (req, res) {
//   console.log(req.method, req.params.deptno);
//   res.status(200);
//   res.send('<h1>dept page(post)</h1>');
// });

// app.post('/dept/:deptno', function (req, res) {
//   console.log(req.method, req.params.deptno);
//   res.status(200);
//   res.send('<h1>dept page(post)</h1>');
// });

// app.put('/dept', function (req, res) {
//   res.status(200);
//   res.send('<h1>dept page(put)</h1>');
// });

// app.delete('/dept', function (req, res) {
//   res.status(200);
//   res.send('<h1>dept page(delete)</h1>');
// });

app.listen(3000);