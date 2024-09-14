let water = [1, 0, 1, 0, 1];
function R(range: number[]) {
	//下标为0 1 2 3 4
	const n = range.length - 1;
	//dp[i]表示灌溉前i个点需要开启的最少水龙头数
	let dp = new Array(n + 1).fill(Number.MAX_SAFE_INTEGER);
	dp[0] = 0;

	for (let i = 0; i <= n; i++) {
		let left = Math.max(0, i - range[i]);
		let right = Math.min(i + range[i], n);
		for (let j = left; j <= right; j++) {
			dp[j] = Math.min(dp[j], dp[left] + 1);
		}
	}
	console.log(dp);
	return dp[n] > range.length ? -1 : dp[n];
}
console.log(R(water));
