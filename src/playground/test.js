const cluster=require('cluster')
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
let arr=[1,2,3,45,52]
arr.forEach((i)=>i*2)