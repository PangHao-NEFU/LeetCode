package 剑指Offer.Easy.五十五_平衡二叉树;

public class Solution {
	//方法1,自顶向下递归,最坏时间On2,空间On,但是其不好的一点是对于每个结点可能会多次求解其深度,造成重复计算
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = treeDeep(root.left);
		int right = treeDeep(root.right);
		return Math.abs(left - right) <= 1&&isBalanced(root.left)&&isBalanced(root.right);

	}
	public static int treeDeep(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = treeDeep(root.left);
		int right = treeDeep(root.right);
		return Math.max(left, right)+1;

	}



	//方法2,自底向上递归,对二叉树做后序遍历,是本题最优解法,如果判定某子树不是平衡树就剪枝,直接向上返回
	//时间On,空间On
	public boolean isBalanced2(TreeNode root) {
		return recur(root) >=0;				//只要返回的不是-1就是平衡树
	}

	//记住,非平衡二叉树一定是至少有一个结点左右子树深度差大于1的
	//如果当前root左右深度差小于等于1,就返回当前子树深度,如果大于1就说明肯定不是平衡树,就返回-1表示此子树不可能为平衡树
	private int recur(TreeNode root) {
		if (root == null) return 0;
		int left = recur(root.left);		//后序遍历左子树
		if(left == -1) return -1;			//-1表示非平衡树,如果左右子树出现非平衡树,直接剪枝返回,后面的不用算了
		int right = recur(root.right);		//后续遍历右子树
		if(right == -1) return -1;			//一旦右子树出现非平衡树,直接返回-1
		return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
	}










	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
