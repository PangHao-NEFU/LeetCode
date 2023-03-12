package HOT100;

public class 十四_最长公共前缀 {

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1) {
			return strs[0];
		} else if (strs.length == 0) {
			return "";
		}
		String ans = "";
		String str = strs[0];

		for (int i = 1; i <= str.length(); i++) {
			String substring = str.substring(0, i);
			int flag=0;
			for (int j = 1; j < strs.length; j++) {

				if (i>strs[j].length()){
					flag=1;
					break;
				}

				String substring1 = strs[j].substring(0, i);
				if (!substring.equals( substring1) ) {
					flag=1;
					break;
				}
			}
			if (flag == 0) {
				ans=substring;
			}
		}
		return ans;
	}

	public static class 十九_删除链表的倒数第个结点 {
	}
}
