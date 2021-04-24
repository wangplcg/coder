package cn.com.algorithm.leetcode.middle;

/**
 * Description:
 * User: wangpl
 * Date: 2020-07-14
 * Time: 23:07
 */

public class LowestCommonAncestor236 {

    /**
     * 236. 二叉树的最近公共祖先 (LCA)
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // [3,5,1,6,2,0,8,null,null,7,4]
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        // 节点为空
        if (node == null || node == p || node == q) {
            return node;
        }
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        return left == null ? right : left;
    }
}
