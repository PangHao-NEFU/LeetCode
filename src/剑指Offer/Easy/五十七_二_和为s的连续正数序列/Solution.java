package 剑指Offer.Easy.五十七_二_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        int left=1,right=1;
        List<int[]> ans=new ArrayList<>();
        int sum=0;
        while (left <= target / 2) {
            if (sum < target) {
                sum+=right;
                right++;
            }else if (sum > target) {
                sum-=left;
                left++;
            } else {
                int[] temp = new int[right - left];
                for (int k = left; k < right; k++) {
                    temp[k-left]=k;
                }
                ans.add(temp);
                sum-=left;
                left++;
            }
        }
        return ans.toArray(new int[ans.size()][]);

    }
}
