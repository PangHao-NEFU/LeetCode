package 剑指Offer.Easy.二十七_二叉树的镜像;

public class Solution {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = mirrorTree(root.left);
		TreeNode right = mirrorTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}




	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
