package 剑指Offer.Easy.二十八_对称的二叉树;

public class Solution {
	//双指针,左指针往左走,右指针就向右走
	public boolean isSymmetric(TreeNode root) {
		return checkSymmetric(root,root);


	}

	private boolean checkSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {	//都是null,可以
			return true;
		}
		if ((left == null && right != null) || (left != null && right == null)) {	//形状都不一样,肯定false
			return false;
		}

		boolean a = checkSymmetric(left.left, right.right);
		boolean b = checkSymmetric(left.right, right.left);
		return a&&b&&(left.val== right.val);	//不光形状一样,对应数字还得相同
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
