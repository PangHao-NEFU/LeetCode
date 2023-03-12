package HOT100.Easy.一三六_只出现一次的数字;

import java.util.HashMap;
import java.util.Set;

public class Solution {
    //方法1,使用map集合,数字作为key,出现次数作为value
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> resMap=new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (resMap.containsKey(num)) {
                resMap.put(num, resMap.get(num) + 1);
            }else{
                resMap.put(num, 1);
            }
        }

        Set<Integer> keySet = resMap.keySet();  //遍历keySet,哪个key对应的value是1,就返回哪个key
        for (Integer key : keySet) {
            Integer value = resMap.get(key);
            if (value == 1) {
                res=key;
                break;
            }
        }

        return res;
    }


}
