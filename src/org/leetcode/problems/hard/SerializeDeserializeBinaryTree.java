package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBinaryTree {

    @Test
    public void test(){
        //comments
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.left.left = new TreeNode(5);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);

        String str =  serialize(root);
        System.out.println(str);
        TreeNode reconstructedRoot = deserialize(str);
        System.out.println(reconstructedRoot);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";

        StringBuilder serialTree = new StringBuilder();

        List<Integer> serialList = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        ll.add(root);
        while (ll.size()>0){
            TreeNode node = ll.getFirst();
            if(node!=null){
                serialList.add(node.val);
            }
            else {
                serialList.add(null);
                ll.removeFirst();
                continue;
            }

            ll.removeFirst();
            ll.addLast(node.left);
            ll.addLast(node.right);
        }

        //serialize
        int lastIdx = serialList.size()-1;
        while(serialList.get(lastIdx) == null){
            serialList.remove(lastIdx--);
        }
        for(int i=0; i<serialList.size(); i++){
            serialTree.append(serialList.get(i)== null ? "null," : serialList.get(i).toString()+",");
        }


        return  serialTree.subSequence(0,serialTree.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.length() == 0)
            return null;

        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.addLast(root);
        int i = 1;
        while(!ll.isEmpty() && i < nodes.length){
            TreeNode node = ll.removeFirst();
            if(node == null)
                continue;
            if(nodes[i].equalsIgnoreCase("null"))
                node.left = null;
            else
                node.left = new TreeNode(Integer.parseInt(nodes[i]));

            if(i+1 < nodes.length){
                if(nodes[i+1].equalsIgnoreCase("null"))
                    node.right = null;
                else
                    node.right = new TreeNode(Integer.parseInt(nodes[i+1]));
            }

            ll.addLast(node.left);
            ll.addLast(node.right);
            i=i+2;
        }

        return root;
    }

    private int getDepth(TreeNode root){
        if(root == null)
            return 0;
        else
            return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
