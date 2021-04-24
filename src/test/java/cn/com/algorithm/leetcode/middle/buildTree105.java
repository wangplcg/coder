package cn.com.algorithm.leetcode.middle;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description:
 * User: wangpl
 * Date: 2020-07-14
 * Time: 23:46
 */

public class buildTree105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     */
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode dfs(int preindex, int instart, int inend, int[] preorder, int[] inorder) {
        if (preindex >= preorder.length) {
            return null;
        }
        if (instart >= inend) {
            return new TreeNode(inorder[instart]);
        }
        int i = preorder[preindex];
        Integer current = map.get(i);

        TreeNode left = dfs(preindex + 1, instart, current - 1, preorder, inorder);
        TreeNode right = dfs(preindex + current - instart + 1, current + 1, inend, preorder, inorder);

        TreeNode treeNode = new TreeNode(preorder[preindex]);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }


}
