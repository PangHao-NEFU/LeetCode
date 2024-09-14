/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 股票涨幅合的概率
 * @param n int整型  股票数
 * @return float浮点型一维数组
 */
function dicesProbability(n) {
	const min = 1;
	const max = 5;
	const prob = [];
	for (let i = min; i <= max; i++) {
		prob.push(1 / (max - min + 1));
	}
	console.log("prob", prob);
	//dp所有可能涨幅和的概率
	let dp = new Array(n * max + 1).fill(0);
	dp[0] = 1;
	for (let stock = 1; stock <= n; stock++) {
		const newDP = new Array(n * max + 1).fill(0);
		for (let i = 0; i <= n * max; i++) {
			for (let j = min; j <= max; j++) {
				// newDP[i] += dp[i - j] * prob[j - 1];//这里
				if (i - j >= 0) {
					newDP[i] += dp[i - j] * prob[j - min];
				}
			}
		}
		dp = newDP;
	}
	// console.log(dp);
	const res = new Array(n * max + 1).fill(0);
	for (let i = 0; i <= n * max; i++) {
		res[i] = dp[i];
	}
	return res.filter((item) => item > 0);
}
module.exports = {
	dicesProbability: dicesProbability,
};
let i = dicesProbability(2);
console.log("🚀 ~ file: 股票.js:42 ~ i:", i);
