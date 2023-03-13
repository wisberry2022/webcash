var mysql = require("mysql2");
var crypto = require('crypto');

var conn = mysql.createConnection({
  host: '192.168.99.100',
  user: 'scott',
  password: 'tiger',
  database: 'lecture'
});

conn.connect(function (err) {
  if (err) {
    console.log(err);
  } else {
    console.log('connect success');
  }
})
