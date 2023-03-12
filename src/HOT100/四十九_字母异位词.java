package HOT100;

import java.util.*;

public class 四十九_字母异位词 {
	public List<List<String>> groupAnagrams(String[] strs) {
		//key是排序过的字符串,map的value是排序过为key的字符串集合
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sortedString = new String(chars);
			if (!map.containsKey(sortedString)) {
				ArrayList<String> strings = new ArrayList<>();
				strings.add(s);
				map.put(sortedString, strings);
			}else {
				map.get(sortedString).add(s);
			}
		}
		return new ArrayList<>(map.values());
	}
}
