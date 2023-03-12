package HOT100;

public class 十九_删除链表的倒数第个结点 {


	 private class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null||(head.next==null&&n==1)) {
			return null;
		}
		ListNode listNode = new ListNode();
		listNode.next=head;
		head=listNode;
		int totalNum = 0;
		while (listNode.next != null) {
			totalNum++;
			listNode = listNode.next;
		}
		int deleteNodeNum = totalNum - n + 1;
		ListNode q=head.next;
		ListNode p = head;
		int currentNum=0;
		while (q != null) {
			currentNum++;
			if (currentNum == deleteNodeNum) {
				p.next = q.next;
				break;
			}
			p=q;
			q=q.next;

		}

		return head.next;
	}
}
