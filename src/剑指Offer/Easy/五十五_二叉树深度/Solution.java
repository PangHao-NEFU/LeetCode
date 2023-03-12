package 剑指Offer.Easy.五十五_二叉树深度;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	//方法1,深度优先,时间On,空间O(二叉树高)
	public int maxDepth(TreeNode root) {

		return treeDeep(root);

	}

	public static int treeDeep(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = treeDeep(root.left);
		int right = treeDeep(root.right);
		return Math.max(left, right)+1;

	}

	//方法2,层序遍历
	public int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int ans = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {		//每次处理一层
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				size--;
			}
			ans++;
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
