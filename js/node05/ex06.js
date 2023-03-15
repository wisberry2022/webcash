var obj1 = { key1: 'val1' };

Object.defineProperty(obj1, 'key1', {
  setter(a) {
    return 'name: ' + a;
  }
});

obj1.key1 = 'edit1';
console.log(obj1);