package HOT100.Easy.二十六_删除有序数组重复项;

/*给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。

由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。

将最终结果插入 nums 的前 k 个位置后返回 k 。

不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
* */
public class Solution {

    public int removeDuplicates(int[] nums) {
        /*方法1,使用treeset,但题中不让用额外空间,取消使用!
        Set numsSet=new TreeSet();
        for (int n : nums) {
            numsSet.add(n);
        }
        int num=numsSet.size();
        Iterator iterator = numsSet.iterator();
        for (int i=0;i<num;i++){
            nums[i]= (int) iterator.next();
        }

        return num;*/

        /*方法2,双指针*/
        /*if(nums.length<=1){
            return nums.length;
        }
        int fast=0;
        int slow=0;
        for (; fast < nums.length-1; fast++) {
            if (nums[fast] != nums[fast+1]) {   //检测数字变化点
                nums[slow++] = nums[fast];
            }

        }
        if(slow>0) {    //防止全是一个数的情况
            if (nums[nums.length - 1] != nums[slow - 1]) {
                nums[slow] = nums[nums.length - 1];
                return slow + 1;
            }
        }

        return 1;*/

        /*优化方法2的双指针*/
        int n = nums.length;
        //两个元素以下的数组直接就返回其长度即可
        if (n <= 1) {
            return n;
        }
        //当数组元素大于等于2个时,至少会有一个(当全都为一个数字的时候)
        int fast = 1, slow = 1;
        for (;fast < n;++fast) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }

        }
        return slow;
    }
}
