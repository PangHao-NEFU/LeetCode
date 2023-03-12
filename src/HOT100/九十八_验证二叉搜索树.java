package HOT100;

import java.util.ArrayList;

public class 九十八_验证二叉搜索树 {
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
   //方法一:dfs,时间On,空间On
	public ArrayList<Integer> arr=new ArrayList<>();
	public boolean isValidBST(TreeNode root) {
		dfs(root);
		for (int i = 0; i < arr.size()-1; i++) {
			if (arr.get(i) >= arr.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		arr.add(root.val);
		dfs(root.right);
	}

	//方法1的优化,使用pre变量保存上一次遍历的值
	int pre = Integer.MIN_VALUE;
	public boolean isValidBST2(TreeNode root) {
		if (root == null) {
			return true;
		}
		//1.还是中序遍历的顺序,先访问左子树
		if (!isValidBST2(root.left)) {
			return false;
		}

		//2.再访问本节点数值,更新pre的值
		if (root.val <= pre) {	//严格大于才行
			return false;
		}
		pre = root.val;


		return isValidBST2(root.right);
	}
}
