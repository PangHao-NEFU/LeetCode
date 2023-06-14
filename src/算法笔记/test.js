const readline = require('readline');

// const rl=readline.createInterface({
//     input:process.stdin,
//     output:process.stdout,
// })

const params=[]
// rl.on('line',(line)=>{
//     params.push(line.trim().split(' ').map((o,i,arr)=>{
//         if (!isNaN(parseInt(o))&&(parseInt(o)!=null)){
//             return parseInt(o)
//         }
//         return o;
//     }))
// })
//
// rl.on('close',()=>{
//     console.log(params)
// })
//
// console.log('done')
// console.log(parseInt('nihao'))

function findArray(arr, num) {
	// write code here
	const n = arr.length;
	//01背包,dp[j]表示背包容量为j的时候拿的最少物品的个数
	//dp[0]=0;
  //dp[j]=Math.min(dp[j],dp[j-arr[i]]+1)
  arr.sort((a,b)=>a-b)
  const dp = Array(num).fill(Number.MAX_SAFE_INTEGER);
  dp[0] = 0;
	const result = [];
	//外层物品内层背包
	for (let i = 0; i < n; i++) {
		for (let j = 1; j <= num; j++) {
			dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
		}
	}
	console.log(dp);
	if (dp[num] === Infinity) {
		return result;
	}
	let remain = num;
	for (let i of arr) {
		if (dp[remain - i] === dp[remain] - 1) {
			result.push(i);
			remain -= i;
		}
	}
	return result;
}
let arr = [1, 4, 2, 4, 5, 6, 3, 1, 2];
let i = findArray(arr, 10);
console.log(i);

function findArray(arr, num) {
	// write code here
	//递归搜索,暴力dfs
  // 初始化最短组合为空数组
  arr.sort((a, b) =>a-b)
	let shortestCombination = [];
	let shortestLength = arr.length + 1;

	dfs(0, [], 0);

	return shortestCombination;

  function dfs(index, currentCombination, currentSum) {
		if (currentSum === num) {
			if (currentCombination.length < shortestLength) {
				shortestCombination = currentCombination;
				shortestLength = currentCombination.length;
			}
			return;
		}

		if (currentSum > num || index >= arr.length) {
			return;
		}

		for (let i = index; i < arr.length; i++) {
			dfs(i + 1, currentCombination.concat(arr[i]), currentSum + arr[i]);
		}
	}
}

