package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class PureStorageTest {

	@Test
	public void test() {
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(3);
		head.next.next = new LinkedListNode(2);
		head.next.next.next = new LinkedListNode(3);
		head.next.next.next.next = new LinkedListNode(3);
		System.out.println("Before :");
		printLinkedList(head);
		LinkedListNode result = removeAll(3, head);
		System.out.println("After :");
		printLinkedList(result);
	}
	private void printLinkedList (LinkedListNode head){
		while(head!=null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
    static LinkedListNode removeAll(int val, LinkedListNode list) {
    	if(list==null)
    		return null;
    	LinkedListNode head = list;
    	LinkedListNode curr = head;
    	while(curr!=null){
    		LinkedListNode next = curr.next;
    		if(next!=null && next.val == val){
    			curr.next = next.next;
    			next.next = null;
    		} else {
        		curr = curr.next;
    		}
    	}
    	return head;
    }
    
    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };
}
