//LeetCode 77 https://leetcode.cn/problems/combinations/
function combine(n: number, k: number): number[][] {
  //组合,回溯求解,n是1到n,k是k个数的组合,递归深度就是k
  let ans: number[][] = [];
  let nums = [];
  for (let i = 1; i <= n; i++) {
    nums.push(i);
  }

  backtracking([], 0, 0);
  return ans;

  function backtracking(path: number[], start: number, deep: number) {
    if (deep == k) {
      ans.push([...path]);
      return;
    }
      
    for (let i = start; i < nums.length-(k-path.length)+1; i++) {   //剪枝
      path.push(nums[i]);
      backtracking([...path], i + 1, deep + 1);
      path.pop();
    }
  }
};