package HOT100.Easy.二二六_翻转二叉树;

public class Solution {
	//递归
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = invertTree(root.left);	//分别对左右子树进行翻转
		TreeNode right = invertTree(root.right);
		root.left = right;						//最后把左右子树颠倒位置,返回root即可
		root.right = left;
		return root;

	}




	public class TreeNode {
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
}
