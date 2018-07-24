package org.leetcode.problems.easy;

import apple.laf.JRSUIUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTrees {

    @Test
    public void test() {
        //prepare t1
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        //prepare 2
        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(5);
            t2.left.left = new TreeNode(8);
            t2.left.right = new TreeNode(10);
        t2.right = new TreeNode(6);


        TreeNode merged = mergeTrees(t1, t2);
        System.out.println("End ...");
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(null == t1)
            return t2;
        if(null == t2)
            return t1;

        t1.val += t2.val;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);


        return t1;
    }

}
