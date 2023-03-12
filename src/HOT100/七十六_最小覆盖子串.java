package HOT100;

public class 七十六_最小覆盖子串 {
	/*
	 * 滑动窗口,左边界为i,右边界为j
	 * 步骤:1.让j增加,直到包含所有target中的字符,
	 * 		2.直到所有字母都已经被增加到,开始移动i,直到窗口中不再包含target中的字符,此时记录下窗口长度
	 * 		3.让i++,继续步骤1,直到右边界到达s的右边界
	 * */
	public String minWindow(String s, String t) {

		//一些特殊情况
		if (s == null || s.length() == 0 || t == null || t.length() == 0){
			return "";
		}
		int[] need = new int[128];		//记录target中出现的子母和次数,正数代表target中出现的字符个数,0表示刚刚好不多不少,负数表示不需要
		//记录需要的字符的个数,初始化记录数组
		for (int i = 0; i < t.length(); i++) {
			need[t.charAt(i)]++;
		}


		//l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
		int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
		//遍历所有字符
		while (r < s.length()) {
			char c = s.charAt(r);
			if (need[c] > 0) {	//需要字符c,表名c正是出现在target中的,count记录总共target还需要几个字符
				count--;
			}
			need[c]--;//把右边的字符加入窗口,如果need[c]为负,就说明此字符是窗口中不需要的字符


			if (count == 0) {//窗口中已经包含所有字符,target中所有字符都已经被窗口满足
				while (l < r && need[s.charAt(l)] < 0) {	//need[s.charAt(l)] < 0代表此处的字符是多余的
					need[s.charAt(l)]++;//释放右边移动出窗口的字符
					l++;//指针右移
				}
				if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，r - l + 1是窗口长度更新最小窗口开始的start
					size = r - l + 1;
					start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
				}
				//l向右移动后窗口肯定不能满足了 重新开始循环
				need[s.charAt(l)]++;		//先恢复s.charAt(l)出现次数,再移动l并让count++
				l++;
				count++;
			}
			r++;
		}
		return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);

	}
}
