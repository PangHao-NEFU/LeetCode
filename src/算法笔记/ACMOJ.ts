import { type } from "os";

/*ACM模式处理树的输入输出,树的输入如果是以数组的方式
构建树很少见,一般是以邻接表方式给出树的结构
rl.on("line", function (line: any) {
  arr.push(line)
});
rl.on("close", () => {
  //执行函数
  console.log('close')
  console.log(arr)
})
*/
// var readline = require("readline");
// const rl = readline.createInterface({
//   input: process.stdin,
//   output: process.stdout,
// });
// console.log('请输入:')
// let arr=<any>[]
// rl.on("line", (line: string) => {
  
//   arr.push(line)
//   console.log(typeof line)
// });
// rl.on("close", () => {
//   //执行函数
//   console.log('close')
//   console.log(arr)
// })

// class TreeNode {
//     val: number
//     left: TreeNode | null
//     right: TreeNode | null
//     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
//         this.val = (val===undefined ? 0 : val)
//         this.left = (left===undefined ? null : left)
//         this.right = (right===undefined ? null : right)
//     }
// }
// var treeArray: number[] = [0]

// //如果是以数组方式存储,i的左孩子是2i+1,右孩子是2i+2
// function buildTree(nums: number[]): TreeNode | null {
//   if (nums.length === 0) {
//     return null;
//   }

//   const root = new TreeNode(nums[0]);
//   const queue: (TreeNode | null)[] = [root];

//   for (let i = 1; i < nums.length; i += 2) {
//     const node = queue.shift();

//     if (nums[i] !== null && nums[i] !== undefined) {
//       const left = new TreeNode(nums[i]);
//       node.left = left;
//       queue.push(left);
//     }

//     if (
//       i + 1 < nums.length &&
//       nums[i + 1] !== null &&
//       nums[i + 1] !== undefined
//     ) {
//       const right = new TreeNode(nums[i + 1]);
//       node.right = right;
//       queue.push(right);
//     }
//   }

//   return root;
// }


function isMountain(arr:Array<any>) {
  const n = arr.length
  let i = 0;
  while (i + 1 < n && arr[i] < arr[i + 1]) {
    i++
  }
  if (i === 0 || i === n - 1) return false;
  while (i + 1 < n && arr[i] > arr[i + 1]) {
    i++
  }
  return i===n-1
}

function findShortestCombination(arr, num) {
	const n = arr.length;
	const dp = Array(n + 1).fill(Infinity);
	const result = [];

	dp[0] = 0;

	for (let i = 0; i < n; i++) {
		for (let j = num; j >= arr[i]; j--) {
			if (dp[j - arr[i]] + 1 < dp[j]) {
				dp[j] = dp[j - arr[i]] + 1;
			}
		}
	}

	if (dp[num] === Infinity) {
		return result;
	}

	let remaining = num;
	for (let i = n - 1; i >= 0; i--) {
		if (remaining >= arr[i] && dp[remaining] === dp[remaining - arr[i]] + 1) {
			result.unshift(arr[i]);
			remaining -= arr[i];
		}
	}

	return result;
}

function findArray(arr, num) {
	// write code here
	const n = arr.length;
	//01背包,dp[j]表示背包容量为j的时候拿的最少物品的个数
	//dp[0]=0;
	//dp[j]=Math.min(dp[j],dp[j-arr[i]]+1)
	const dp = Array(num).fill(Infinity);
	const result = [];
	//外层物品内层背包
	for (let i = 0; i < n; i++) {
		for (let j = 1; j <= num; j++) {
			dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
		}
  }
  console.log(dp)
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
let arr = [1, 4, 2, 4, 5, 6, 3, 1, 2]
let i=findArray(arr, 10)
console.log(i)