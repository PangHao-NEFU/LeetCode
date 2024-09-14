// const rl = require("readline").createInterface({ input: process.stdin });
// var iter = rl[Symbol.asyncIterator]();
// const readline = async () => (await iter.next()).value;
let input;
let ans = [];
let path = [];
let max = Number.MIN_SAFE_INTEGER;
// void (async function () {
// 	// Write your code here
// 	while ((line = await readline())) {
// 		input = line;
// 	}
// 	dfs(input);
// 	console.log(max);
// })();

function dfs(remain) {
	if (remain == "") {
		const sum = path.reduce((pre, cur) => pre + cur, 0);
		if (sum > max) {
			max = sum;
			ans = path.slice(0);
		}
		return;
	}
	for (let i = 1; i <= Math.min(remain.length, 2); i++) {
		let part = remain.slice(0, i);
		path.push(+part);
		dfs(remain.slice(i));
		path.pop();
	}
}

dfs("12345");
console.log(max);
console.log(ans);
