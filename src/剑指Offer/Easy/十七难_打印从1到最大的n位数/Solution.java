package 剑指Offer.Easy.十七难_打印从1到最大的n位数;

import java.util.ArrayList;

public class Solution {
	//当不考虑大数问题时
	public int[] printNumbers(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i < Math.pow(10, n) ; i++) {
			list.add(i);
		}
		int[] ints = new int[list.size()];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = list.get(i);
		}
		return ints;
	}

}
