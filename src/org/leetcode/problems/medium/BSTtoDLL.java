package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BSTtoDLL {

    @Test
    public void test(){
        Node root = new Node(4, new Node(), new Node());
        root.left.val = 2;
        root.right.val = 5;

        root.left.left = new Node(1, null, null);
        root.left.right = new Node(3, null, null);

        root = new Node(2, new Node(), null);
        root.left.val = 1;

        Node head = treeToDoublyList(root);
        System.out.println(head.val);
        System.out.println(head.left.val);
    }

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        treeToDoublyListUtil(root);

        Node tail = root;
        while(tail.right!=null){
            tail = tail.right;
        }

        Node head = root;
        while(head.left!=null){
            head = head.left;
        }

        tail.right = head;
        head.left = tail;
        return head;
    }
    public void treeToDoublyListUtil(Node root) {
        if(root.left==null && root.right == null) return;

        Node left = root.left;
        Node right = root.right;
        root.right = findMin(root.right);
        root.left = findMax(root.left);
        if(left!=null)
            treeToDoublyListUtil(left);
        if(right!=null)
            treeToDoublyListUtil(right);
        if(root.right!=null)
            root.right.left = root;
        if(root.left!=null)
            root.left.right = root;
    }

    //find Min in this subtree
    public Node findMin(Node root){
        if(root == null) return null;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    public Node findMax(Node root){
        if(root == null) return null;
        while (root.right!=null){
            root = root.right;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};