package 剑指Offer.Easy.六_从尾到头打印链表;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	//法1,头插法创建逆序链表
	public int[] reversePrint(ListNode head) {
		ListNode head1=null;
		int count=0;
		while (head != null) {
			ListNode temp = new ListNode(head.val);
			temp.next=head1;
			head1=temp;
			count++;
			head=head.next;
		}
		int[] ints = new int[count];
		for (int i = 0; i < count && head1 != null; head1 = head1.next, i++) {
			ints[i]=head1.val;
		}
		return ints;
	}

	//法2,三指针原地逆置
	public int[] reversePrint2(ListNode head) {
		ListNode tempHead=head;
		int count=0;
		while (tempHead != null) {
			count++;
			tempHead = tempHead.next;
		}

		int[] ints = new int[count];
		ListNode pre=null;
		ListNode now=head;
		while (now != null) {
			ListNode s=now.next;
			now.next=pre;
			pre=now;
			now=s;
		}
		for (int i = 0; i < count && pre != null; pre = pre.next, i++) {
			ints[i]=pre.val;
		}
		return ints;
	}

	//法3,正序遍历后逆置数组
	public int[] reversePrint3(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head=head.next;
		}
		Collections.reverse(list);
		Integer[] array = list.toArray(new Integer[0]);
		int[] ints = new int[list.size()];
		for (int i = 0; i < ints.length; i++) {
			ints[i]=array[i];
		}
		return ints;
	}

	//链表结点的定义
	public class ListNode {
		int val;
        ListNode next;
		ListNode(int x) { val = x; }
    }
}
