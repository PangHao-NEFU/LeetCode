package HOT100.Easy.五十八_最后一个单词的长度;

public class Solution {
    public static void main(String[] args) {
        String s = " HELLO  :  WORLD  :  ";
        String[] s1 = s.split("\\s+");

    }

    public int lengthOfLastWord(String s) {
        String[] strings = s.split("\\s+");
        int length = strings.length;

        return strings[length-1].length();
    }

}
