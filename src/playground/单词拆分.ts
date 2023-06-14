export function wordSplit(s: string, wordDict: string[]): boolean {
  // write code here
  //1. dp[i]表示考虑前i个字符,可否拆分为字典
  // 2. dp[i]=true if : dp[j]是true并且s.slice(j+1,i+1)存在于字典 j从0到i
  let slen=s.length
  const dp:boolean[] = new Array(slen+1).fill(false)
  dp[0] = true  //3.初始化条件,前0个肯定是true
  for (let i = 1; i < slen+1; i++){
    for (let j = 0; j < i; j++) {
      if (dp[j] && wordDict.includes(s.slice(j, i))) {
        dp[i] = true
        break
      }
    }
  }
  return dp[slen]
  
}
