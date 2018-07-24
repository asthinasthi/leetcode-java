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
public class MergeTwoList {

	@Test
	public void test() {
		ListNode p1 = new ListNode(1), l1 = p1;
		ListNode p2 = new ListNode(2), l2 = p2;

		for (int i = 3; i <= 10; i++) {
			if (i % 2 == 0) {
				p2.next = new ListNode(i);
				p2 = p2.next;
			} else {
				p1.next = new ListNode(i);
				p1 = p1.next;
			}
		}
		ListNode result = mergeTwoLists(l1, l2);
		printLinkedList(result);
	}
	
	public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode head = l1.val < l2.val ? l1:l2;
		ListNode nonHead = l1.val < l2.val ? l2: l1;
		head.next = mergeTwoListsRecursive(head.next, nonHead);
		return head;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode tempHead = new ListNode(0);
		ListNode head = tempHead;
		while (p1 != null || p2 != null) {
			if (p1 == null) {
				head.next = p2;
				break;
			}

			if (p2 == null) {
				head.next = p1;
				break;
			}

			if (p1.val < p2.val) {
				head.next = new ListNode(p1.val);
				p1 = p1.next;
			} else {
				head.next = new ListNode(p2.val);
				p2 = p2.next;
			}
			head = head.next;
		}

		return tempHead.next;
	}

	public void printLinkedList(ListNode head) {

		while (head != null) {
			System.out.print(head.val + " --> ");
			head = head.next;
		}
		System.out.println();
	}
}
