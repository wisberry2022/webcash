// 함수
function func1() {
  console.log('func1...');
}

var func2 = function (msg) {
  console.log('func2...' + msg);
  return 5;
}

var result = func2('result');
console.log(result);

func1();
func2('abcd');

(function () {
  console.log('익명함수');
})();

// 화살표 함수
var func3 = msg => {
  console.log('func3...' + msg);
}

func3('msg');

(() => {
  console.log('익명함수2');
})();

var func05 = () => {
  return 6;
};

var func06 = msg => { msg + '출력' };
result = func06('abcdefgh');
console.log(result);

result = func05();
console.log(result);

var func07 = msg => { };
result = func07('abc');
console.log(result);