const rl = require("readline").createInterface({ input: process.stdin, output: process.stdout });
var iter = rl[Symbol.asyncIterator]();
const readline = async () => (await iter.next()).value;

let input = [];
void (async function () {
	// Write your code here
	while ((line = await readline())) {
		let tokens = line.split(" ").map((i) => +i);
		input.push(tokens);
	}
	console.log(input);
	// input.slice(1).forEach((i) => Resolve(i[0], i[1]));
})();

// function Resolve(a, b) {
// 	console.log(Math.ceil(a / b));
// }
// Resolve(10, 3);
