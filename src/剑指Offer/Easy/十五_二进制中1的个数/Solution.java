package 剑指Offer.Easy.十五_二进制中1的个数;

public class Solution {
	public static void main(String[] args) {
		hammingWeight(-3);
	}
	//也称之为汉明距离

	/*请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
	并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
	在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
	*/
	public static int hammingWeight(int n) {
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) == (1 << i)) {	//或者n & (1 << i)) != 0;
				ret++;
			}
		}
		return ret;
	}

}
