package org.leetcode.problems.hard;

import org.junit.Test;

public class ValidBST {

    @Test
    public void test() {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);

        TreeNode root1 = new TreeNode(1);
        root1.left = null;
        root1.right = new TreeNode(1);

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(11);
        root2.right.right = new TreeNode(20);
        root2.right.left.right = new TreeNode(14);

        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(5);
        root3.left.left = new TreeNode(0);
        root3.left.right = new TreeNode(2);
        root3.left.right.right = new TreeNode(3);
        root3.right.left = new TreeNode(4);
        root3.right.right = new TreeNode(6);

        TreeNode root4 = new TreeNode(0);
        root4.right = new TreeNode(1);

        TreeNode root5 = new TreeNode(3);
        root5.left = new TreeNode(1);
        root5.right = new TreeNode(5);
        root5.left.left = new TreeNode(0);
        root5.left.right = new TreeNode(2);
        root5.right.left = new TreeNode(4);
        root5.right.right = new TreeNode(6);

        TreeNode root6 = new TreeNode(98);
        root6.left = new TreeNode(-57);
        root6.left.right = new TreeNode(58);
        root6.left.right.left = new TreeNode(31);

        System.out.println(isValidBST(root6));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public boolean isValidBSTUtil(TreeNode root, int min, int max){

        if(root == null)
            return true;


        if(root.val < max && root.val > min){
            return isValidBSTUtil(root.left, min, root.val )
                    && isValidBSTUtil(root.right, root.val, max);
        } else {
            return false;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
