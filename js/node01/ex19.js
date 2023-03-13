var fs = require('fs');

fs.watchFile("temp01.txt", function () {
  console.log('수정');
})

fs.writeFileSync("temp01.txt", "첫 번째 수정");
fs.writeFile("temp01.txt", "두 번째 수정", function (e) { });