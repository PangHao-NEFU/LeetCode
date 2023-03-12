package HOT100;

public class 二十三_合并K个升序链表 {
      //解法1:本题的想法是化k个链表合并为两个链表合并,两个链表合并完再跟后面一个合并,再跟后面一个合并...
      //时间复杂度为 O(k^2n),空间O1
      public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                  return null;
            } else if (lists.length == 1) {
                  return lists[0];
            }

            ListNode sum = null;
            for (int i = 0; i < lists.length; i++) {
                  sum=mergeTwoLinkList(sum,lists[i]);
            }
            return sum;
      }

      //解法2.通过分治法来进行合并,时间O(knlogk),空间O(logK)
      public ListNode mergeKLists2(ListNode[] lists) {
            if (lists.length == 0) {
                  return null;
            } else if (lists.length == 1) {
                  return lists[0];
            }
            return merge(lists, 0, lists.length - 1);

      }
      public ListNode merge(ListNode[] lists,int startIndex,int endIndex) {
            if (startIndex == endIndex) {
                  return lists[startIndex];
            }
            if (startIndex > endIndex) {
                  return null;
            }

            int mid = (startIndex + endIndex) >> 1;
            ListNode left = merge(lists, startIndex, mid);
            ListNode right = merge(lists, mid + 1, endIndex);
            return mergeTwoLinkList(left, right);
      }

      //基本的两链表合并的迭代写法
      private ListNode mergeTwoLinkList(ListNode list1, ListNode list2) {
            if (list1 == null) {
                  return list2;
            } else if (list2 == null) {
                  return list1;

            }
            ListNode head = new ListNode();
            ListNode tar = head;
            while (list1 != null && list2 != null) {
                  if (list1.val < list2.val) {
                        tar.next = list1;
                        list1 = list1.next;
                        tar = tar.next;
                  } else {
                        tar.next = list2;
                        list2 = list2.next;
                        tar = tar.next;
                  }
            }
            tar.next=list1==null?list2:list1;
            return head.next;
      }


      private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
