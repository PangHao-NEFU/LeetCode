
export function VaildIpAddr(s: string): string[]{
  let result: string[] = []
  debugger
  dfs(0, '',0)
  return result
  /**
   * @description: 广度优先遍历所有可能的ip解空间
   * @returns {*} void
   * @param {number} currentIdx 目前遍历到s的哪个下标了
   * @param {string} path       收集到的路径上的一部分结果
   * @param {number} count      收集了几个了,因为ip只能由四段组成
   */
  function dfs(currentIdx: number, path: string, count: number): void {
    if (currentIdx == s.length && count == 4) { //index必须已经走到最后了,并且已经满4个了
      result.push(path.slice(0, -1))
      console.log('加入了',path)
      return 
    }
    console.log('进入for')
    for (let i = 1; i <= 3; i++){
      if (currentIdx + i > s.length) break; //保证不越界!,要不然后面dfs的时候可能会有问题
      let current:string=s.slice(currentIdx,currentIdx+i)  
      if (parseInt(current) > 255 || (current.startsWith('0')&&current.length>1)) {
        //以0开头没事,只要长度大于1就行
        continue;
      }
      dfs(currentIdx+i,path+current+'.',count+1)
    }
  }
}

console.log(VaildIpAddr("0122146"))