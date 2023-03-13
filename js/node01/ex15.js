var fs = require('fs');

fs.stat('js02', fs.constants.F_OK, function (a, b) {
  console.log(a, b);
})