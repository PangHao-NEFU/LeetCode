package 剑指Offer.Easy.五十二_两个链表的第一个公共节点;

public class Solution {
	//双指针的浪漫相遇,时间Om+n,空间O1
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return  null;
		}
		ListNode A=headA;
		ListNode B=headB;
		while (headA != headB) {
			if (headA != null) {
				headA = headA.next;
			} else {
				headA=B;
			}
			if (headB != null) {
				headB = headB.next;
			} else {
				headB=A;
			}
		}
		return headA;

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
