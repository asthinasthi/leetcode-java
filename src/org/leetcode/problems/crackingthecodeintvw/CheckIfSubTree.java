package org.leetcode.problems.crackingthecodeintvw;

public class CheckIfSubTree {

    public boolean check(TreeNode T1, TreeNode T2){

        if(T1 == null && T2 == null) return true;

        if(T1 == null || T2 == null) return false;

        if(T1.val == T2.val){
            return check(T1.left, T2.left) && check(T1.right, T2.right);
        } else {
            return check(T1.left, T2) || check(T1.right, T2);
        }
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
}
