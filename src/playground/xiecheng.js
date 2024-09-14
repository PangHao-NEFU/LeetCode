// const readline = require("readline");

// const rl = readline.createInterface({
// 	input: process.stdin,
// 	output: process.stdout,
// });
// let ln = 0;
// let q;
// let sa = [];
// rl.on("line", function (line) {
// 	if (ln == 0) {
// 		q = +line;
// 	} else {
// 		sa.push(line);
// 	}
// 	ln++;
// });

// rl.on("close", () => {
// 	for (i = 0; i < sa.length - 1; i += 2) {
// 		let aa = resolve(sa[i], sa[i + 1]);
// 		console.log(aa);
// 	}
// });

function resolve(s1, s2) {
	//字母相同对应的s2不同就炸了
	let m1 = new Map();
	let m2 = new Map();
	for (let i = 0; i < s1.length; i++) {
		if (m1.has(s1[i])) {
			m1.set(s1[i], [...m1.get(s1[i]), i]);
		} else {
			m1.set(s1[i], [i]);
		}
	}
	for (let i = 0; i < s2.length; i++) {
		if (m2.has(s2[i])) {
			m2.set(s2[i], [...m2.get(s2[i]), i]);
		} else {
			m2.set(s2[i], [i]);
		}
	}
	for (let en of m1) {
		let c = en[0];
		let app = en[1];
		let tmp = [];
		for (let appindex of app) {
			if (tmp.length == 0) tmp.push(s1[appindex]);
			if (!tmp.includes(s1[appindex])) return "No";
		}
	}

	return m1.size >= m2.size ? "Yes" : "No";
}

resolve("abc", "aaa");

const MOD = 1e9 + 7;

function countWays(n, k) {
	const nStr = n.toString();
	const nLen = nStr.length;

	const dp = new Array(nLen + 1);
	for (let i = 0; i <= nLen; i++) {
		dp[i] = new Array(k + 1);
		for (let j = 0; j <= k; j++) {
			dp[i][j] = new Array(75).fill(0);
		}
	}

	dp[0][0][0] = 1;

	for (let i = 1; i <= nLen; i++) {
		for (let j = 0; j <= Math.min(i, k); j++) {
			for (let p = 0; p < 75; p++) {
				for (let digit = 0; digit < 10; digit++) {
					const np = (p * 10 + digit) % 75;

					if (j < k) {
						dp[i][j + 1][np] += dp[i - 1][j][p];
						dp[i][j + 1][np] %= MOD;
					}

					dp[i][j][p] += dp[i - 1][j][p];
					dp[i][j][p] %= MOD;
				}
			}
		}
	}

	const answer = (dp[nLen][k][0] - 1 + MOD) % MOD;

	return answer;
}
