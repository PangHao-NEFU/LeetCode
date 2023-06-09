package HOT100.Easy.二三四_回文链表;

import java.util.ArrayList;

public class Solution {
	public boolean isPalindrome(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head=head.next;
		}
		for (int i = 0,j=list.size()-1 ; i <=j; i++,j--) {
			if (list.get(i) != list.get(j)) {
				return false;
			}
		}
		return true;
	}



	private class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
