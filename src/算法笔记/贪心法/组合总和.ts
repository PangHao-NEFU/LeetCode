function combinationSum(candidates: number[], target: number): number[][] {
  //回溯法先画出递归树会好做
    
  var ans: number[][] = [];
  backtracking([], 0, target);
  return ans;

  function backtracking(path: number[], deep: number, target: number) {
    if (target < 0) {
      return;
    }
    if (target === 0) {
      ans.push([...path]);
      return;
    }
    for (let i = deep; i < candidates.length; i++) {
      //每个元素可以重复使用
      path.push(candidates[i]);
      backtracking([...path], i, target - candidates[i]);
      path.pop();
    }
  }
}
