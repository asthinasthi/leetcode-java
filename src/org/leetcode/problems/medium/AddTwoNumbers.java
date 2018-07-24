package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Test;

public class AddTwoNumbers {

	@Test
	public void test() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(8);
		l2.next.next.next = new ListNode(3);
		l2.next.next.next.next = new ListNode(7);
		printLinkedList(l1);
		printLinkedList(l2);
		ListNode result = addTwoNumbers(l1, l2);

		printLinkedList(result);
	}

/*	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode result = new ListNode(0);
		ListNode resultHead = result;
		while (l1 != null && l2 != null) {
			int digitSum = l1.val + l2.val + carry;
			carry = digitSum >= 10 ? 1 : 0;
			result.val = digitSum % 10;
			result.next = new ListNode(0);
			result = result.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int digitSum = l1.val + carry;
			carry = digitSum >= 10 ? 1 : 0;
			result.val = digitSum % 10;
			result.next = new ListNode(0);
			result = result.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			int digitSum = l2.val + carry;
			carry = digitSum >= 10 ? 1 : 0;
			result.val = digitSum % 10;
			result.next = new ListNode(0);
			result = result.next;
			l2 = l2.next;
		}

		if (carry > 0) {
			result.val = carry;
		} else {
			ListNode tail = resultHead;
			while (tail.next.next != null) {
				tail = tail.next;
			}
			tail.next = null;
		}

		return resultHead;
	}
*/	
	public ListNode addTwoNumbers(ListNode l1 , ListNode l2){
		ListNode head = new ListNode(0);
		ListNode prev = head;
		int carry = 0;
		
		while(l1!=null || l2!=null || carry!=0 ){
			ListNode curr = new ListNode(0);
			int sum = ((l1==null)?0:l1.val) + ((l2==null)?0:l2.val) + carry;
			carry = sum/10;
			curr.val = sum%10;
			prev.next = curr;
			prev = curr;
			l1 = (l1==null)?l1:l1.next;
			l2 = (l2==null)?l2:l2.next;
		}
		return head.next;
	}

	public void printLinkedList(ListNode head) {

		while (head != null) {
			System.out.print(head.val + " --> ");
			head = head.next;
		}
		System.out.println();
	}
}
