package HOT100.Easy.五四三_二叉树直径.Solution;
//此题本质是求二叉树的深度,记录每个结点的左子树深度加右子树深度,取最大的一个值
public class Solution {
	int maxd=0;		//记录(左子树深度+右子树深度)的最大值
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return maxd;
	}
	public int depth(TreeNode node){
		if(node==null){
			return 0;
		}
		int Left = depth(node.left);	//计算左子树深度
		int Right = depth(node.right);	//计算右子树深度
		maxd=Math.max(Left+Right,maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
		return Math.max(Left,Right)+1;//返回节点深度
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
