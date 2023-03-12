package 剑指Offer.Easy.二十二_链表中倒数第k个节点;

public class Solution {
	public ListNode getKthFromEnd(ListNode head, int k) {
		int count=0;	//链表共有count个结点
		ListNode head1=head;
		while (head1 != null) {
			head1=head1.next;
			count++;
		}
		if (k > count) {
			return null;
		}
		int num=count-k+1;	//要删除的节点的正向序号,从1开始计
		int now=1;
		while (now < num&&head!=null) {
			head=head.next;
			now++;
		}
		return head;
	}


	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
