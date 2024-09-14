var readline = require("readline");

//方式1
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

let arr = [];
rl.on("line", (line) => {
	arr.push(line);
	console.log(typeof line);
});
rl.on("close", () => {
	//执行函数
	console.log("close");
	console.log(arr);
});

//方式2
var iter = rl[Symbol.asyncIterator]();
const readline = async () => (await iter.next()).value;

void (async function () {
	// Write your code here
	while ((line = await readline())) {
		let tokens = line.split(" ");
		let a = parseInt(tokens[0]);
		let b = parseInt(tokens[1]);
		console.log(a + b);
	}
})();
