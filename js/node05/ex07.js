var arr = ['item1', 'item2', 'item3', 'item4'];

// for (i = 0; i < arr.length; i++) {
//   console.log('for', arr[i]);
// }

// for (item of arr) {
//   console.log('for-of', item);
// }

// for (idx in arr) {
//   console.log('for-in', idx, arr[idx]);
// }

var result = [];
arr.forEach(ele => result.push(ele + '번'));
// console.log(result);
var result = arr.map(ele => ele + "번");
// console.log(result);

var result2 = arr.filter((ele, idx) => {
  // console.log(ele, idx);
  return idx %= 2;
});

var result3 = arr.reduce((cur, nxt, idx, arr) => {
  // console.log(cur, nxt, idx, arr);
})

var result = arr.find((ele, idx, target) => {
  // console.log('find');
  return ele == 'item2';
})

let arr2 = JSON.parse('[]');
console.log(arr2);

// console.log(arr, result);