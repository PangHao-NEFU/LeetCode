package 剑指Offer.Easy.五_替换空格;

public class Solution {
	public String replaceSpace(String s) {
		String[] s1 = s.split(" ",-1);
		String ans="";
		for (int i=0;i<s1.length;i++) {
			if (i!=s1.length-1){
				s1[i] = s1[i].concat("%20");
			}
			ans+=s1[i];
		}

		return ans;

	}
}
