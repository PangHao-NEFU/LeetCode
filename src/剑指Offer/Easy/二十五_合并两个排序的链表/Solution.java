package 剑指Offer.Easy.二十五_合并两个排序的链表;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=new ListNode(-1);	//head所指的是头结点,值为-1
		ListNode now=head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				now.next = l1;
				l1 = l1.next;
				now = now.next;
			} else {
				now.next=l2;
				l2=l2.next;
				now = now.next;
			}
		}

		if (l1 != null) {
			now.next=l1;
		}
		if (l2 != null) {
			now.next=l2;
		}
		return head.next;
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
