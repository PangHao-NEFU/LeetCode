package HOT100.Easy.九十四_二叉树中的中序遍历;

import java.util.*;

//此方法使用循环实现,使用栈这种数据结构,通过两个大循环来遍历左右子树
public class Solution2 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> nodesStack = new LinkedList<>();
            nodesStack.push(root);
            while (!nodesStack.isEmpty()) {
                TreeNode popNode = nodesStack.pop();
                if (popNode.left != null) {
                    nodesStack.push(popNode);
                    nodesStack.push(popNode.left);
                    popNode.left=null;
                }else{
                    ans.add(popNode.val);
                    if (popNode.right != null) {
                        nodesStack.push(popNode.right);
                        popNode.right=null;
                    }
                }
            }
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
