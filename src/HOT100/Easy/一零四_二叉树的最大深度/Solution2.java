package HOT100.Easy.一零四_二叉树的最大深度;

import java.util.ArrayDeque;

/*广度优先遍历*/
public class Solution2 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int maxDeep=0;
        queue.add(root);
        while (!queue.isEmpty()) {
            //每次都需要把一层的结点全部出队列,并把他们孩子加入队列,一次处理一层,层数会加一
            int nowFloorNodeNum=queue.size();       //1.记录当前层最多有多少结点,这是一个当前层还在队列里的结点数量的计数器

            while (nowFloorNodeNum > 0) {           //2.遍历当前层结点,(关键)
                TreeNode pollNode = queue.poll();   //2.1出队并将孩子加入队列
                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
                nowFloorNodeNum--;              //2.2出队一个,队列中当前层节点数就-1,此变量相当于打上标记,哪些结点属于当前层
            }

            maxDeep++;                          //3.当遍历过一层的所有结点后,层数+1

        }
        return  maxDeep;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
