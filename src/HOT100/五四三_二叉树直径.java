package HOT100;

public class 五四三_二叉树直径 {
	public int diameterOfBinaryTree(TreeNode root) {
		//本题要记录每个节点的子树最大深度和每个节点的最大直径
		if (root == null) {
			return 0;
		}
		dfs(root);
		return ans;

	}
	public int ans;		//本全局变量记录每个节点的最大直径

	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftNodeDeepth = dfs(root.left);		//左子树深度
		int rightNodeDeepth = dfs(root.right);		//右子树深度

		int currentNodeDiameter = leftNodeDeepth + rightNodeDeepth;		//记录当前结点直径
		ans = Math.max(ans, currentNodeDiameter);
		return Math.max(leftNodeDeepth, rightNodeDeepth) + 1;		//返回本层深度

	}











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
}
