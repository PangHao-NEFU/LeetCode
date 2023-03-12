package 剑指Offer.Easy.三十二_从上到下打印二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}

		Deque<TreeNode> deque=new ArrayDeque<>();
		deque.offer(root);	//add也是可以的

		while (!deque.isEmpty()) {
			int nowLayerNodeNum = deque.size();
			List<Integer> temp = new ArrayList<>();
			while (nowLayerNodeNum > 0) {	//一次处理一层结点
				TreeNode pollNode = deque.poll();
				temp.add(pollNode.val);
				if (pollNode.left != null) {
					deque.offer(pollNode.left);

				}
				if (pollNode.right != null) {
					deque.offer(pollNode.right);

				}
				nowLayerNodeNum--;

			}
			ans.add(temp);
		}
		return ans;
	}


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
