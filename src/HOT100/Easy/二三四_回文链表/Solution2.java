package HOT100.Easy.二三四_回文链表;

public class Solution2 {
	//快慢指针,快指针一次走两步,慢指针一次走一步,慢指针走的时候翻转前半部分链表,快指针走到结尾时
	//慢指针刚好在链表中间,然后从中间向两边分别遍历链表.
	//需要注意,反转链表需要prepre,pre和slow,加上快指针fast,共需要四个指针.
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		ListNode slow = head, fast = head;
		ListNode pre = head, prepre = null;
		while(fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
			pre.next = prepre;
			prepre = pre;
		}
		if(fast != null) {
			slow = slow.next;
		}
		while(pre != null && slow != null) {
			if(pre.val != slow.val) {
				return false;
			}
			pre = pre.next;
			slow = slow.next;
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
