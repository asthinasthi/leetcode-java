/**
 * 
 */
package org.leetcode.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leetcode.problems.medium.ListNode;

/**
 * @author amathad
 * 
 */
public class SwapNodePairs {

	@Test
	public void test() {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		printLinkedList(root);
		root = swapPairs(root);
		printLinkedList(root);
	}

	public ListNode swapPairs(ListNode head) {
		ListNode prev = new ListNode(0);
		ListNode zeroHead = prev;
		prev.next = head;

		while (head != null && head.next != null) {
			ListNode nextHead = head.next.next;
			prev.next = swapCouple(head);
			prev = prev.next.next;
			head = nextHead;
		}
		if (head == null)
			prev.next = null;
		else
			prev.next = head;
		return zeroHead.next;
	}

	private ListNode swapCouple(ListNode head) {
		ListNode tail = head.next;
		tail.next = head;
		return tail;
	}

	public void printLinkedList(ListNode head) {

		while (head != null) {
			System.out.print(head.val + " --> ");
			head = head.next;
		}
		System.out.println();
	}
}
