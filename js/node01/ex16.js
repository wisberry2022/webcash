var fs = require('fs');

fs.writeFile('./temp01.txt', "hihi hello nodeJS", function (err) {
  console.log(err);
  console.log('hihi');
})

fs.readFile('temp01.txt', function (err, data) {
  console.log(data.toString('utf-8'));
});