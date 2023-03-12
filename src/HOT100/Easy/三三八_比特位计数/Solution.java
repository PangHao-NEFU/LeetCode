package HOT100.Easy.三三八_比特位计数;

public class Solution {
	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			ans[i] = Integer.bitCount(i);
		}
		return  ans;
	}

}
