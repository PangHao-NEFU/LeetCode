package 剑指Offer.Easy.五十八_翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i] .equals("") ) {     //防止strings出现''
                sBuilder.append(strings[i]).append(" ");
            }
        }
        if (sBuilder.length() - 1 >= 0) {       //防止出现s全是空格或为空字符串的情况
            sBuilder.deleteCharAt(sBuilder.length() - 1);
        }
        return  sBuilder.toString();
    }
}
