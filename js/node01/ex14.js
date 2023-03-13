var fs = require('fs');
try {
  fs.rmdir('js01');
} catch (e) {
  console.log('success');
  console.log(e);
}
