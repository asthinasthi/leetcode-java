/**
 * 
 */
package org.leetcode.problems.easy;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class InvertBinaryTree {

	@Test
	public void test() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		printBinaryTree(root);
		
		root = invertTree(root);
		System.out.println("*****************RESULT**************************");
		printBinaryTree(root);
	}

	private void printBinaryTree(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<InvertBinaryTree.TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node.left!=null)
				System.out.print(node.left.val);
			System.out.print("---");
			if(node.right!=null)
				System.out.print(node.right.val);
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
			System.out.println();
		}
	}
    public TreeNode invertTree(TreeNode root) {
    	//For every node swap
    	//recurse on left
    	//recurse on right
    	
    	if(root == null)
    		return null;
    	
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	invertTree(root.left);
    	invertTree(root.right);
    	return root;
    }
    
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
}
