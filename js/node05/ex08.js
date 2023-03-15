class Cl01 {
  constructor(name, year) {
    this.name = name;
    this.year = year;
  }

  func() {
    console.log('Cl01 func run...');
  }
}

let obj1 = new Cl01('user1', 2000);
// console.log(obj1.name, obj1.year);
// obj1.func();

class Cl03 extends Cl01 {
  constructor(name, year) {
    super(name, year);
  }
}

let obj4 = new Cl03("user02", 2022);
console.log(obj4);

function Cl02(a, b) {
  this.name = a;
  this.year = b;
  this.func = function () {
    console.log('Cl02 func run...');
  }
}

// let obj2 = new Clo2();
// console.log(obj2);