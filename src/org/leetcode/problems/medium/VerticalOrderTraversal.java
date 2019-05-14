package org.leetcode.problems.medium;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class VerticalOrderTraversal {

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        root = new TreeNode(6);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.left = new TreeNode(4);

        verticalOrder(root);
        for(List list: result){
            for(Object num: list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> verticalOrder(TreeNode root) {

        Queue<TreeNodeX> queue = new LinkedList<>();
        queue.add(new TreeNodeX(root, 0));
        while(!queue.isEmpty()){
            TreeNodeX nodeX = queue.poll();
            if(map.containsKey(nodeX.index)){
                List<Integer> list = map.get(nodeX.index);
                list.add(nodeX.node.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nodeX.node.val);
                map.put(nodeX.index, list);
            }
            if(nodeX.node.left!=null)
                queue.add(new TreeNodeX(nodeX.node.left, nodeX.index-1));
            if(nodeX.node.right!=null)
                queue.add(new TreeNodeX(nodeX.node.right, nodeX.index+1));
        }

        Set<Integer> keySet = map.keySet();
        TreeSet<Integer> sortedKeys = new TreeSet<>();
        sortedKeys.addAll(keySet);

        for(Integer key: sortedKeys){
            result.add(map.get(key));
        }
        return result;
    }


    class TreeNodeX  {
        int index = 0;
        TreeNode node = null;
        TreeNodeX(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
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
