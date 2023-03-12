package HOT100.Easy.九十四_二叉树中的中序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//方法1,递归
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if (root!=null){
            midTree(root, ans);
        }
        return ans;
    }

    public static void midTree(TreeNode root,ArrayList<Integer> ans) {


            if (root.left != null) {
                midTree(root.left,ans);
            }
            ans.add(root.val);
            if (root.right != null) {
                midTree(root.right,ans);

        }
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
