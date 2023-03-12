package HOT100.Easy.二十八_子串位置;

public class Solution {
    public static void main(String[] args) {
        int i = strStr("abc", "c");
        System.out.println(i);

    }



    public static int strStr(String haystack, String needle) {
        if(needle==""){
            return 0;
        }
        if(haystack.length()<needle.length()) {
            return -1;
        }
        if(haystack!=null&&needle!=null&&haystack.equals(needle)){
            return 0;
        }
        int neeleLen = needle.length();
        int i=0;
        for (i = 0; i < haystack.length()-neeleLen+1; i++) {
            String substring = haystack.substring(i, i + neeleLen);
            if (substring != null && substring.equals(needle)) {
                return i;
            }
        }


        return -1;
    }
}
