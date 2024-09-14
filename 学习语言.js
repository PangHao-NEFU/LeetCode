const rl = require("readline").createInterface({ input: process.stdin });
var iter = rl[Symbol.asyncIterator]();
const readline = async () => (await iter.next()).value;

let input = [];
let n, m;
void (async function () {
	// Write your code here
	while ((line = await readline())) {
		let tokens = line.split(" ").map(Number);
		input.push(tokens);
	}
	n = input[0][0];
	m = input[0][1];
	input = input.slice(1);
	//构建每个人会的语言图,下标代表人的编号,set中每项是每个人会的语言编号
	const language = new Array(n).fill(0).map(() => new Set());
	for (let i = 0; i < input.length; i++) {
		language[i].add(...input[i].slice(1));
	}
	const peopleLang = input.map((item) => item.slice(1)); //每个人语言
	let ans = R(n, language, peopleLang);
	console.log(ans);
})();

function R(n, language, peopleLang) {
	//构建交流图
	const graph = new Array(n).fill(0).map(() => []);
	//遍历每个人
	for (let i = 0; i < n; i++) {
		//遍历每个人的语言
		for (let lang of language[i]) {
			for (let j = 0; j < n; j++) {
				if (i !== j) {
					//不是同一个人
					if (language[j].has(lang)) {
						graph[i].push(j);
						break;
					}
				}
			}
		}
	}

	//深度优先查找连通分量
	const visited = new Array(n).fill(false);
	let components = 0;
	function dfs(node) {
		visited[node] = true;
		for (let neighbor of graph[node]) {
			if (!visited[neighbor]) {
				dfs(neighbor);
			}
		}
	}
	for (let i = 0; i < n; i++) {
		if (!visited[i]) {
			dfs(i);
			components++;
		}
	}
	const langLearn = Math.max(0, components - 1);
	return langLearn;
}
