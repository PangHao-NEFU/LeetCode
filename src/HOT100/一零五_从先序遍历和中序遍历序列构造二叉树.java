package HOT100;

public class 一零五_从先序遍历和中序遍历序列构造二叉树 {
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

    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder=preorder;
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTreeHelper(0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int preStart, int preEnd, int midStart, int midEnd) {
        if (preStart == preEnd) {
            return null;
        }
        int rootValue = preorder[preStart]; //确定根的值了,然后去中序遍历里找对应的左子树和右子树
        TreeNode root = new TreeNode(rootValue);
        int inorderRootIndex=0;
        for (int i = midStart; i < midEnd; i++) {
            if (inorder[i] == rootValue) {
                inorderRootIndex = i;
                break;
            }
        }
        root.left = buildTreeHelper(preStart + 1, preStart + inorderRootIndex - midStart + 1, midStart, inorderRootIndex);
        root.right = buildTreeHelper(preStart + inorderRootIndex - midStart + 1, preEnd, inorderRootIndex + 1, midEnd);
        return root;
    }

}
