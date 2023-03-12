package HOT100.Easy.一四一_环形链表;

import java.util.HashSet;

public class Solution {
    //方法1,哈希表,把经过的结点全都加入哈希表中,如果新加入的结点在哈希表里就是有环
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodeSet=new HashSet<>();
        while (head != null) {
            if (!nodeSet.contains(head)){
                nodeSet.add(head);
                head=head.next;
            }else{
                return true;
            }
        }
        return false;
    }


    /*方法2,龟兔赛跑,快指针一次移动2格,慢指针一次移动一格,如果快指针或快指针下一个结点为null,说明已经到达末尾,就是无环
    如果有环,快指针与慢指针在多次迭代后一定会相遇*/
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;  //注意一定要保证快指针和快指针的next不能为null,否则会出现空指针异常
        }
        return true;
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
