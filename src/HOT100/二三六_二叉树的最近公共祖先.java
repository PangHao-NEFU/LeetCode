package HOT100;

public class 二三六_二叉树的最近公共祖先 {
	//dfs后序遍历
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return afterDfs(root, p, q);
	}

	public TreeNode afterDfs(TreeNode root,TreeNode p,TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}

		TreeNode left = afterDfs(root.left, p, q);
		TreeNode right = afterDfs(root.right, p, q);
		if (left == null) return right;
		if (right == null) {
			return left;
		}
		return root;
	}

	private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
