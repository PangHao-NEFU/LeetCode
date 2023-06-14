
//     let n1=4,k1=3;
//     let arr1=[-1,2,-1,3];

       
        
    
// let sum = arr1.reduce((o,i) => { return o+i }, 0)
//     console.log(sum
// )
        
// function minAvg(nums,k) {
//     const n = nums.length;
//     const dp = new Array(n + 1).fill(null).map(() => {return new Array(k + 1).fill(0) });
//     const presum = new Array(n + 1).fill(0);
//     for (let i = 1; i <= n; i++){
//         presum[i] = presum[i - 1] + nums[i - 1];
//     }
//     for (let i = 1; i <= n; i++){
//         for (let j = 1; j <= k; j++){
//             if (j === 1) {
//                 dp[i][j] = (presum[i] - presum[0]) / i;
//             } else if(j<=i){
//                 dp[i][j] = Infinity;
//                 for (let m = j - 1; m < i; m++){
//                     dp[i][j] = Math.min(
//                       dp[i][j],
//                       dp[m][j - 1] + (presum[i] - presum[m]) / (i - m)
//                     );
//                 }
//             }
//         }
//     }
//     return dp[n][k];
// }
    
// const readline = require('readline');

// const rl = readline.createInterface({
//     input: process.stdin,
//     output: process.stdout
// });
// var n = -1; // 初始状态为负数，表示还没开始读取
// var cur_line = 0;
// var peachNum = 0;
// var suan = [];
// var tian=[]
// rl.on('line', function (line) {
//     if (n < 0) {
//         peachNum = parseInt(line.trim())
//         cur_line++
//     } else if(cur_line==1){
//         const tokens = line.split(" ");
//         for (let i of tokens) {
//             suan.push(parseInt(i));
//         }
//         cur_line++;
//     } else if (cur_line == 2) {
//         const tokens = line.split(" ");
//         for (let i of tokens) {
//           tian.push(parseInt(i));
//         }
//     }
    
    
// });
// function maxSweetness(arr1,arr2){
//     const n = arr1.length;
//     let total1 = arr1.reduce((acc, cur) => acc + cur, 0);
//     let maxSweet=0;
//     for (let i = 0; i < n; i++){
//         const sour = arr1[i];
//         const sweet=arr2[i];
//         const newSweet = (total1 - sour) * sweet / sour;
//         maxSweet = Math.max(maxSweet, newSweet);
//     }
//     return maxSweet;
// }
//创建二维数组
// let arr1 = new Array(3).fill(new Array(4).fill(0));  //这种方法是错的!
// arr1[0][1] = 2;
// console.log("🚀 ~ file: kaoshi1.ts:82 ~ arr1:", arr1)

//快速创建二维数组的方法,推荐使用arr2这种方法,简洁易懂
// let dp: number[][] = Array.from(new Array(3), () => new Array(4).fill(0));
// let arr2: number[][] = new Array(3).fill(0).map(() => new Array(4).fill(0));
// let arr2 = new Array(10).fill(0).map((_, i) => i+1);

// // dp[0][1] = 1;
// // console.log(dp);
// arr2[0][1]=1
// console.log(arr2)

let arrtest = [1, 2, 3, 4]
function changeArr(arr: number[]) {
    arr[0] = 100;
}
changeArr(arrtest)
console.log(arrtest)