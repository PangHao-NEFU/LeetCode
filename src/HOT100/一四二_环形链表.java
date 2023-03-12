package HOT100;

import java.util.ArrayList;
import java.util.List;

public class 一四二_环形链表 {
	private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
	public ListNode detectCycle(ListNode head) {
		List<ListNode> nodearray = new ArrayList<>();
		if (head == null) {
			return null;
		}
		int index=0;
		while (head != null) {
			if (!nodearray.contains(head)) {
				nodearray.add(head);
				head = head.next;
			} else {
				return head;
			}
		}
		return null;


	}
}
