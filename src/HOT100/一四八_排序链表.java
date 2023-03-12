package HOT100;

public class 一四八_排序链表 {
	private class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

	//你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
	//方法1,冒泡排序,时间On2,空间o1不符题意
	//方法2,归并排序,但要空间o1无法使用递归,自底向上进行链表合并,两个有序链表的合并我们已经熟悉
	public ListNode sortList(ListNode head) {
		//一些准备工作
		if (head == null) {
			return head;
		}
		int length = 0;		//看看链表有多长
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}
		ListNode dummyHead = new ListNode(0, head);    //设定一个空的头结点

		//每次将链表拆分成若干个长度为subListLength的子链表 , 并按照每两个子链表一组进行合并
		for (int subListLength = 1; subListLength <= length; subListLength *= 2) {
			ListNode prev = dummyHead, curr = dummyHead.next;//起始条件

			while (curr != null) {
				//拆分链表1
				ListNode head1 = curr;
				for (int i = 1; i < subListLength && curr.next != null; i++) {
					curr = curr.next;
				}
				//拆分链表2并将其与链表1断开
				ListNode head2 = curr.next;
				curr.next = null;
				curr = head2;
				for (int i = 1; i < subListLength && curr != null && curr.next != null; i++) {
					curr = curr.next;
				}

				//别忘了链表2的结尾也需要跟后面断开,断开前别忘了保存其下一个结点的指针到next中,要不然链表就丢了
				ListNode next = null;
				if (curr != null) {
					next = curr.next;
					curr.next = null;
				}

				//合并链表1和链表2,将结果连接到prev后面,并移动prev到最后
				ListNode merged = merge(head1, head2);
				prev.next = merged;
				while (prev.next != null) {
					prev = prev.next;
				}
				curr = next;
			}
		}



		return  dummyHead.next;
	}
	private ListNode merge(ListNode head1, ListNode head2) {	//两个有序链表的合并
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
		while (temp1 != null && temp2 != null) {
			if (temp1.val <= temp2.val) {
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if (temp1 != null) {
			temp.next = temp1;
		} else if (temp2 != null) {
			temp.next = temp2;
		}
		return dummyHead.next;
	}

}
