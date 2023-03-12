package HOT100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 一零二_二叉树的层序遍历 {
	private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
	public List<List<Integer>> levelOrder(TreeNode root) {
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();	//存放结点的队列
		ArrayList<List<Integer>> result = new ArrayList<>();	//总答案
		if (root == null) {
			return result;
		}
		//先把根节点加入队列
		queue.add(root);

		while (!queue.isEmpty()) {
			int num=queue.size();
			ArrayList<Integer> path = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				TreeNode pollNode = queue.poll();
				path.add(pollNode.val);
				if (pollNode.left != null) {
					queue.add(pollNode.left);
				}
				if (pollNode.right != null) {
					queue.add(pollNode.right);
				}
			}
			result.add(path);
		}

		return result;
	}
}
