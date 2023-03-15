var f1 = function () {
  console.log(this);
};

var f2 = () => console.log(this);

var obj1 = {
  name: 'test1',
  // setName: function (a) { this.name = a; }
  setName: a => { obj1.name = a; }
}

var result = obj1.setName('aaaa');
console.log(obj1);