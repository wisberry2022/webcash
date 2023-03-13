var func1 = function () {
  console.log('func1 run...');
}

var su1 = 1234;
// exports.func1 = func1;
// exports.su1 = su1;
// exports를 사용한다면 아래와 같은 형식으로 함수를 export 해야한다
exports.func4 = function () {
  console.log('func4 run...');
}