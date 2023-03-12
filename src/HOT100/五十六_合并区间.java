package HOT100;

import java.util.Arrays;

public class 五十六_合并区间 {
	public int[][] merge(int[][] intervals) {
		//先对数组排序,如果没交叉,直接添加,如果有交叉,修改返回数组中当前元素的第二个值为二者较大值
		if (intervals.length == 0) {
			return new int[0][2];
		}
		Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
		int[][] res = new int[intervals.length][2];
		int index = -1;		//表示当前res已经更新到哪了
		for (int[] interval : intervals) {
			if (index == -1 || res[index][1] < interval[0]) {	//如果是第一个或者区间没重合,直接添加
				res[++index] = interval;
			} else {
				res[index][1] = Math.max(interval[1], res[index][1]);
			}
		}
		return Arrays.copyOfRange(res, 0, index+1);
	}
}
