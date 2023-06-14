// function test1(par: number): string
// function test1(par:string):string
// function test1(par: number | string): string {
//     if (typeof par === 'number') {
//         return String(par);
//     }
//     if (typeof par === 'string') {
//         return par;
//     }
// }

// console.log(test1(1));
// console.log(test1("hello"));
let arr = new Array<number>(10)
arr.forEach((i) => {
	console.log(i)
})



function solve(str1:string, str2:string) {
	let dp = new Array(str1.length + 1)
		.fill(0)
		.map(() => new Array(str2.length + 1).fill(1));
	//dp[i][j]表示str1前i个变成str2前j个所需要的次数
	//dp[i][j]= dp[i - 1][j - 1] //当str1[i-1]==str2[j-1],这种情况根本无需操作
	//当str1[i-1]!=str2[j-1]时,有三种情况
	//1.删除str1[i-1],这时候就需要dp[i-1][j]+1次
	//2.插入str1[i-1],我们将str1前i个数转换为str2的前j-1个数,然后插入str2[j-1]就好了!所以需要dp[i][j-1]+1次
	//3.修改str1[i-1],我们将str1[i-1]直接修改为str2[j-1],需要dp[i-1][j-1]+1次
	//然后看看上面三种方案哪个最少,就选哪个
	let m = str1.length;
	let n = str2.length;
	for (let i = 1; i < m + 1; i++) {
		dp[i][0] = i;
	}
	for (let j = 1; j < m + 1; j++) {
		dp[0][j] = j;
	}
	for (let i = 1; i <= m; i++) {
		for (let j = 1; j <= n; j++) {
			if (str1[i - 1] === str2[j - 1]) {
				//字符相等就不需要操作,直接过
				dp[i][j] = dp[i - 1][j - 1];
			} else {
				dp[i][j] =
					Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
			}
		}
	}
	return dp[m][n];
}

function solve2(n:number, T:number, params:Array<Array<any>>) {
	//两个数组分别存储每个城市向左和向右能到的最大路径长
	let left = new Array(n + 1).fill(0);
	let right = new Array(n + 1).fill(0);
	for (let i = 0; i < T; i++) {
		if (params[i][0] == "L") {
			if (params[i][1] != 1) {
				left[params[i][1]] += 1;
			}
		} else if (params[i][0] == "R") {
			if (params[i][1] != n) {
				right[params[i][1]] += 1;
			}
		} else if (params[i][0] == "Q") {
			console.log(left[params[i][1]], " ", right[params[i][1]]);
		}
	}
}
