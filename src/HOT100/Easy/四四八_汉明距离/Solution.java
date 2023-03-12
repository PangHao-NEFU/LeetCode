package HOT100.Easy.四四八_汉明距离;

public class Solution {
	//汉明距离就是异或后的二进制1的个数
	public int hammingDistance(int x, int y) {
		int z=x^y;
		return Integer.bitCount(z);
	}


}
