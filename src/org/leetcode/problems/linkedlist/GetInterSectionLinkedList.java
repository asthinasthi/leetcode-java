package org.leetcode.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leetcode.problems.medium.ListNode;

public class GetInterSectionLinkedList {

	@Test
	public void test() {
/*		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(20);
		headA.next.next.next = new ListNode(5);

		ListNode headB = new ListNode(3);
		headB.next = new ListNode(4);
		headB.next.next = headA.next.next.next;

		headA.next.next.next.next = new ListNode(6);*/
		
		ListNode headA = new ListNode(1);
		for(int i=2 ;i<=13 ;i++){
			headA.next = new ListNode(i);
		}
		
		ListNode headB = headA;

		System.out.println(getIntersectionNode(headA, headB).val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA == null || headB == null)
			return null;
		
		ListNode a = headA;
		ListNode b = headB;
		while(a!=b){
			a = a==null?headB:a.next;
			b = b==null?headA:b.next;
		}
		return a;
	}
	
	/*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		ListNode tempA = headA;
		int lengthA = 1;
		ListNode tempB = headB;
		int lengthB = 1;
		while (tempA.next != null || tempB.next != null) {
			if (tempA.next != null) {
				lengthA++;
				tempA = tempA.next;
			}
			if (tempB.next != null) {
				lengthB++;
				tempB = tempB.next;
			}
		}
		if(tempA!=tempB)//no intersection
			return null;
		
		int headStart = 0;
		ListNode longerHead = null;
		ListNode shorterHead = null;
		if (lengthA == lengthB) {
			headStart = lengthA / 2 - 1;
			longerHead = headA;
			shorterHead = headB;
		} else if (lengthA > lengthB) {
			headStart = lengthA - lengthB;
			longerHead = headA;
			shorterHead = headB;
		} else {
			headStart = lengthB - lengthB;
			longerHead = headB;
			shorterHead = headA;
		}
		int i=1;
		while (i <= headStart) {
			longerHead = longerHead.next;
			i++;
		}
		
		while(longerHead!=shorterHead){
			longerHead = longerHead.next;
			shorterHead = shorterHead.next;
		}
		return longerHead;
	}*/
}

