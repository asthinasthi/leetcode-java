package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PathSum3 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.right.right = new TreeNode(11);


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(-2);
        root1.right = new TreeNode(-3);
        int ans;
//                ans = pathSum(root1, -2);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(-2);
        root2.right = new TreeNode(-3);

        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);

        root2.right.left = new TreeNode(-2);
        root2.right.right = null;

        root2.left.left.left = new TreeNode(-1);

        numOfPaths = 0;
        ans = pathSum(root2, 1);
        System.out.println(ans);
    }

    Integer numOfPaths = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        List<Integer> list = new ArrayList<>();
        if(root.val == sum)
            numOfPaths++;

        list.add(root.val);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.addAll(list);
        list2.addAll(list);
        pathSumUtil(root.left, sum, list1);
        pathSumUtil(root.right, sum, list2);

        return numOfPaths;
    }

    public void pathSumUtil(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;

        int levelSum = 0;
        list.add(root.val);
        for (int i = list.size() - 1; i >= 0; i--) {
            levelSum += list.get(i);
            if (levelSum == sum) {
                numOfPaths++;
            }
        }
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        pathSumUtil(root.left, sum, list1);
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        pathSumUtil(root.right, sum, list2);
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
