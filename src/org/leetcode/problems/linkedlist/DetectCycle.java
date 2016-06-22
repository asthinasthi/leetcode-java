package org.leetcode.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leetcode.problems.medium.ListNode;

public class DetectCycle {

	@Test
	public void test() {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;

		System.out.println(detectCycle(head).val);
	}

	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null || head.next.next == null)
			return null;
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		boolean hasCycle = false;
		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast) {
				hasCycle = true;
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		if (hasCycle) {
			fast = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		} else {
			return null;
		}
	}

}
