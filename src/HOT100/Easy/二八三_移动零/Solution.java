package HOT100.Easy.二八三_移动零;

public class Solution {
	public void moveZeroes(int[] nums) {
		//冒泡排序
		for (int j = nums.length - 1; j >= 0; j--) {
			int flag=0;
			for (int i = 0; i < j; i++) {
				if (nums[i]==0) {
					int temp = nums[i];
					nums[i]=nums[i+1];
					nums[i+1]=temp;
					flag=1;
				}
			}
			if (flag == 0) {
				break;
			}
		}

	}
}
