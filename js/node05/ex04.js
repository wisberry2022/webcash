//object
var obj1 = new Object();
obj1.name = 'obj1';
var obj2 = { key1: 'val1', obj1 };
console.log(obj2);
var obj3 = { obj1 };
console.log(obj3);

var obj4 = { name: 'tester', setName: function (a) { this.name = a; } }
obj4.setName('editer');
console.log(obj4);

var obj5 = { ename: 'tester', setName(a) { this.ename = a; } };
obj5.setName('EDITER');
console.log(obj5);