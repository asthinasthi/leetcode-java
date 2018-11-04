package org.leetcode.problems.medium;

import apple.laf.JRSUIUtils;
import org.junit.Test;

public class LCABinaryTree {

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode lca = lowestCommonAncestor(root, new TreeNode(0), new TreeNode(8));

        System.out.println(lca.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        if(root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null && right!=null){
            return root;
        }
        return  left == null ? right : left;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
