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
public class InsertionSort {

	@Test
	public void test() {
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);

		printLinkedList(head);
		head = insertionSortList(head);
		printLinkedList(head);

	}

	public ListNode insertionSortList(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode orderedTail = dummyHead;
		ListNode toBeSorted = head;

		while (toBeSorted != null) {
			ListNode prev = dummyHead;
			while (prev.next.val <= toBeSorted.val && prev.next != toBeSorted) {
				prev = prev.next;
			}
			if (prev.next != toBeSorted) {// exchange
				orderedTail.next = toBeSorted.next;
				toBeSorted.next = prev.next;
				prev.next = toBeSorted;
			} else {
				orderedTail = toBeSorted;
			}
			toBeSorted = orderedTail.next;
		}
		return dummyHead.next;
	}

	public void printLinkedList(ListNode head) {

		while (head != null) {
			System.out.print(head.val + " --> ");
			head = head.next;
		}
		System.out.println();
	}
}
