package HOT100.Easy.五十三_最大子序和;

import java.util.ArrayList;
import java.util.Comparator;

/*给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。*/
public class Solution {
    //方法1,贪心,当前元素加上之前的和如果比当前元素还小,那就抛弃之前的和,重新开始找子串
    /*public int maxSubArray(int[] nums) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for (int eachNum : nums) {
            sum= Math.max(eachNum, sum + eachNum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;}*/
    //方法2,动态规划 dp[i]=max(dp[i-1]+num[i],num[i])
    public int maxSubArray(int[] nums) {
        //int[] dp=new int[nums.length];
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(nums[0]) ;
        for (int i = 1; i < nums.length; i++) {
            dp.add(Math.max(dp.get(i-1)+nums[i], nums[i]));

        }
        dp.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        return dp.get(dp.size()-1);
    }



}
