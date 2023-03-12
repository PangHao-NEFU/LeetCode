package HOT100;



public class 一二四_二叉树中的最大路径和 {
	int max;
	public int maxPathSum(TreeNode root) {
		max=Integer.MIN_VALUE;
		dfs(root);
		return max;
	}

	public int dfs(TreeNode root){
		if(root==null){return 0;}
		int left=dfs(root.left);
		int right=dfs(root.right);
		left=left>0?left:0;
		right=right>0?right:0;
		int currentSum=root.val+left+right;
		max=Math.max(currentSum,max);
		return root.val+Math.max(left,right);      //注意这里是向上贡献的最大值,左子树和右子树要取大
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
