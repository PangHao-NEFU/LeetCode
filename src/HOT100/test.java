package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {
	public static void main(String[] args) {
//		HashMap<Integer, String> map = new HashMap<>();
//		map.put(1, "str1");
//		map.put(2, "str2");
//		map.put(3, "str3");
//		Set<Map.Entry<Integer, String>> entries = map.entrySet();
////		map.replace(1, "1234", "114514");
////		System.out.println(map);
//		map.forEach((key,v)->{
//			System.out.println(key);
//			System.out.println(v);
//		});
//		Deque<Integer> stack = new ArrayDeque<>();
//		stack.add(1);
//		stack.addFirst(2);
//		stack.add(3);
//		System.out.println(stack.element());
//		System.out.println(stack.getLast());
//		//System.out.println(stack.);
//		String string = "dahgdjpasgh";
//		char[] chars = string.toCharArray();
//		//System.out.println(chars[0]);
//		int[][] a = new int[2][3];
//
////		for (int[] i : a) {
////			for (int j : i) {
////				System.out.println(j);
////			}
////		}
////		int[] c = {1,23,4,56};
////		System.out.println(c[9]);
////		String[] sf = {"123", "sdfa"};
////		System.out.println(sf[0]);
//		int sfs=1235;
//		String string1 = new String(String.valueOf(sfs));
//		System.out.println(string1+string1.getClass());
		//int数组和集合互转
		int[] a = {1, 2, 3, 5, 6};
		ArrayList<Integer> integers1 = new ArrayList<>();
		Collections.addAll(integers1, 1, 2, 45, 3462, 54234, 54352, 6234);

		//Arrays.stream(a).collect()
		int[] ints = integers1.stream().mapToInt(s -> Integer.valueOf(s)).toArray();
		String[] strings = new String[2];
		Arrays.stream(strings).forEach(System.out::println);
		Integer[] c1 = {1, 2, 3, 5};
		Arrays.stream(c1).mapToInt(Integer::valueOf).toArray();

	}

	public static class 二十一_合并两个有序链表 {
		//定义结点
		public class ListNode {
			int val;
			ListNode next;
			ListNode() {}
			ListNode(int val) { this.val = val; }
			ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		}

		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			//此解法是正常的循环遍历解法
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

		public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
			//此方法是递归写法
			if (list1 == null) {
				return list2;
			} else if (list2 == null) {
				return list1;
			}
			if (list1.val < list2.val) {
				list1.next = mergeTwoLists2(list1.next, list2);
				return list1;
			} else {
				list2.next = mergeTwoLists2(list1, list2.next);
				return list2;
			}
		}
	}
}
