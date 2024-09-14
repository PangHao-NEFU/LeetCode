const cluster = require("cluster");
// let i=['d','c','a', 'bb',]
// i.sort()
// console.log(i.join(' '))
// let s1 = `hello\\tworld`
// console.log(s1)

// let p = Promise.resolve('123')
// p.then((data) => {
//   console.log(data)
//   return Promise.reject('456')
// }).then((data) => {
//   console.log(data)
//   return Promise.reject('789')
// }).catch(e => console.log('我是catch',e))
//   .finally(() => { console.log('我是finally') })

// let a = 10;
// function fn() {
// 	console.log(a);
// }
// function s(fn) {
// 	let a = 20;
// 	fn();
// }
// s(fn);

// console.log(cluster.isPrimary);

// var a = 2;
// function b() {
//   console.log(a)
// }
// console.log()

// const regex = /\[(.*?)\]/s;
// const str = `Sure, here are some recommendations for a bright and colorful room:

// [
//   {
//     "wall": "#FFDAB9", // peach puff
//     "floor": "white tiles"
//   },
//   {
//     "wall": "#F0E68C", // khaki
//     "floor": "gray parquet"
//   },
//   {
//     "wall": "#87CEEB", // sky blue
//     "floor": "white parquet"
//   }
// ]

// These options use bright and warm colors that can help create a cheerful atmosphere in the room.`;

// const match = str.match(regex);
// console.log(match.length)
// match.forEach((o) => {
//   console.log(o)
// })
// let arr=[1,2,3,45,52]
// arr.forEach((o,i,arr) => arr[i]=o*2)
// console.log(arr)

//  let arr1=[1,2,3,4,5]
// for (let i of arr1) {
// if (arr1.length > 100) break;
// //   arr1.push(i+4)
// // }
// // console.log(arr1)
// const path = require('path')
// console.log(__dirname,__filename)
// console.log(process.cwd()===path.resolve())
// let m = new Map([
// 	["a", 1],
// 	["b", 2],
// ]);

// m.forEach((v, k) => console.log(v, k));

let num = "100005430000";
let split = 4;
let revNum = num.split("").reverse();
let count = 0;
for (let i = 0; i < revNum.length; i++) {
	count++;
	if (count === split) {
		count = 0;
		i++;

		revNum.splice(i, 0, ",");
	}
}
let reversed = revNum.reverse().join("");
if (reversed[0] === ",") {
	reversed = reversed.slice(1);
}
Number.MIN_SAFE_INTEGER;

// console.log(s.split("").reverse().join(""));
// let split = 4;

// let reg = new RegExp(`(?=\\B(\\d{${split}})+$)`, "g");

// let a = s.replace(reg, ",");
// console.log(a);
