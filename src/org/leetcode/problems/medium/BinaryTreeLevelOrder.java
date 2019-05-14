package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BinaryTreeLevelOrder {

    @Test
    public void test(){

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return levelOrder;
        queue.add(root);
        List<Integer> levelList = new ArrayList<>();
        while(!levelList.isEmpty()){
            TreeNode currNode = queue.poll();

            levelList.add(currNode.val);
            queue.add(currNode.left);
            queue.add(currNode.right);
        }
        return levelOrder;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }