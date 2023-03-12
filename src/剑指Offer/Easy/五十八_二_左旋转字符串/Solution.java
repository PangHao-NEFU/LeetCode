package 剑指Offer.Easy.五十八_二_左旋转字符串;

import java.util.ArrayList;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        ArrayList<Character> charArray = new ArrayList<Character>();
        for (int i = n ; i < s.length(); i++) {
            charArray.add(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            charArray.add(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();

    }
}
