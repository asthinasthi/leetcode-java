package org.leetcode.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leetcode.problems.medium.ListNode;

public class Cycle {

	@Test
	public void test() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = head;
		/*
		 * head.next.next = new ListNode(3); head.next.next.next = new
		 * ListNode(4); head.next.next.next.next = new ListNode(5);
		 * head.next.next.next.next.next = new ListNode(6);
		 * head.next.next.next.next.next.next = head.next.next;
		 */

		System.out.println(hasCycle(head));
	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return false;
		ListNode slow = head.next;
		ListNode fast = head.next.next;

		while (slow != fast
				&& (slow != null && fast != null && fast.next != null)) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow != fast ? false : true;

	}
}
