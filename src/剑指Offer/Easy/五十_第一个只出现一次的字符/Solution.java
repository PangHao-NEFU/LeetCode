package 剑指Offer.Easy.五十_第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Set;

public class Solution {
	public char firstUniqChar(String s) {
		if (s == null) {
			return ' ';
		}
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c,1);
			} else {
				map.put(c, map.get(c)+1);
			}
		}
		Set<Character> keySet = map.keySet();
		for (Character c : keySet) {
			if (map.get(c) == 1) {
				return c;
			}
		}
		return ' ';
	}
}
