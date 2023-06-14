// Promise.resolve().then(() => {
// 	console.log("我是promise1");
// 	return new Promise<void>((resolve, reject) => {
// 		setTimeout(() => {
// 			console.log("我是特殊的定时器")
// 			resolve()
// 		}, 3000)
// 	})
// }).then(() => {
// 	console.log("我是promise1的第二个.then")
// });

import { log } from "console"

// queueMicrotask(() => {
// 	console.log("微任务队列");
// });

// Promise.resolve().then(() => {
// 	console.log("我是promise2");
// }).then(() => {
// 	console.log("我是promise2的第二个.then")
// });

// setImmediate(() => {
// 	console.log("我是setImmediate");
// });

// setTimeout(() => {
// 	console.log("我是定时器");
// });

// process.nextTick(() => {
// 	console.log("我是nexttick1");
// });

// console.log("我是主线程");

// new Promise((resolve, reject) => {
// 	throw new Error();
// })
// 	.then(
// 		() => {},
// 		() => {
// 			console.log("被.then1处理");
// 		}
// 	)
// 	.then(
// 		() => {
// 			console.log("成功");
// 		},
// 		() => {
// 			console.log("被.then2处理");
// 		}
// 	)
// 	.catch(() => {
// 		console.log("被catch处理");
// 	});

new Promise((resolve, reject) => { 
	setTimeout(() => {
		console.log("我是第一个定时器")	//2
		Promise.resolve().then(()=>{
			console.log("我是在异步任务添加的微任务回调")	//3
		}).then(() => {
			log("helloworld")
		})
		resolve(0);
	})
}).then(() => {
	log("promise1的回调")		//4
})
Promise.resolve().then(() => {
	console.log("我是微任务1")		// 1
})

setTimeout(() => {
	console.log("我是第二个定时器")		//5
})