package HOT100.Easy.一六零_相交链表;

import java.util.ArrayList;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (headA != null) {
            listNodes.add(headA);
            headA=headA.next;
        }
        ListNode posNode=null;
        int i=0;
        while (headB != null) {
            if (listNodes.contains(headB)) {
                return headB;
            }
            if (headB != null) {
                headB = headB.next;

            }
        }
        return posNode;

    }

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
        }
    }
}
