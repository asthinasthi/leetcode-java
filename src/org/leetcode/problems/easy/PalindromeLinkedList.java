/**
 * 
 */
package org.leetcode.problems.easy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leetcode.problems.medium.ListNode;

/**
 * @author amathad
 *
 */
public class PalindromeLinkedList {

	@Test
	public void test() {
/*		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(1);*/
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(5);
		
		System.out.println("Original: ");
		printLinkedList(head);
		System.out.println();
		System.out.println(isPalindrome(head));
		
	}

/*	public class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}*/
	
    public boolean isPalindrome(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while(fast!=null && fast.next!=null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	if(fast!=null) slow = slow.next;
    	ListNode midHead = slow;
    	ListNode tail = reverseList(midHead);
    	
    	while(tail!=null && tail.val == head.val){
    		head = head.next;
    		tail = tail.next;
    	}
    	return tail==null;
    }
    
    public ListNode reverseList(ListNode head){
    	ListNode prev = null;
    	while(head!=null){
    		ListNode next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	return prev;
    }
    
    public void printLinkedList(ListNode head){
    	
    	while(head!=null){
    		System.out.print(head.val + " --> ");
    		head = head.next;
    	}
    }
}
