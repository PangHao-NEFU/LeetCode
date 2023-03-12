package HOT100;

public class 一一四_二叉树展开为链表 {
	//本题返回void,说明要原地来做,大概的算法流程是,将右子树移动到左子树最右边,然后左子树移到右子树
	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left == null) {
				root = root.right;
			} else {
				TreeNode pre = root.left;		//寻找左子树最右边
				while (pre.right != null) {
					pre = pre.right;
				}

				pre.right = root.right;			//找到后将右子树插入到左子树最右边
				root.right = root.left;
				root.left = null;
				root = root.right;
			}
		}
	}



	//树节点定义
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
