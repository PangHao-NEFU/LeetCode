/**回溯法 backtracking
 * 回溯就是递归的过程,常用于解决for循环层数根本不确定
 * 回溯法的本质是DFS深度优先搜索结果集,常见的是树形结构dfs,也会有二维数组的回溯(四方向)
 * 可解决问题:
 * 暴力搜索:
 * 组合问题:
 * 排列问题:
 * 切割数组,字符串:
 * 子集:
 * 排列:
 * 棋盘问题:
 */
/*一般情况下回溯法所需要的参数:
    path:收集路径
    start:每层for循环开始的基准,决定整个树的宽度
    deep:递归深度,决定整个树的高度

    回溯搜索的剪枝:常常在for循环的条件上做文章,for循环的条件如果大的话,可以考虑剪枝
*/

//模板:
// function  backtracking(collection:any,...args) {
//     if (args) {
//         //终止条件,收集答案
//         return;
//     }
//     for (collection;){
//         //处理节点
//         backtracking(collection);
//         //回溯
//     }
// }