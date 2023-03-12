package HOT100.Easy.二零六_反转链表;

public class Solution {
	//三指针原地逆置,时间On,空间O1
	public ListNode reverseList(ListNode head) {
		if (head == null||head.next==null) {
			return head;
		}
		ListNode p =head;
		ListNode q=head.next;
		head.next=null;
		while (q != null) {
			ListNode s=q.next;
			q.next=p;
			p=q;
			q=s;

		}
		return p;
	}

	//解法二,头插法,时间On,空间On
	public ListNode reverseList2(ListNode head) {
		ListNode myHead=null;
		while (head != null) {
			myHead=new ListNode(head.val,myHead);
			head=head.next;
		}
		return myHead;
	}





	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
