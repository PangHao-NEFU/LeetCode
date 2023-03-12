package 剑指Offer.Easy.十八_删除链表中的节点;

public class Solution {
	public ListNode deleteNode(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode pre=head;
		ListNode current=head.next;
		if (pre.val == val) {
			return current;
		}
		while (current!=null&&current.val != val) {
			pre=current;
			current = current.next;
		}
		if (current != null) {
			pre.next = current.next;

		}
		return head;
	}




	public class ListNode {
		int val;
        ListNode next;
        ListNode(int x) { val = x; }
   }
}
