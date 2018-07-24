package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.List;

public class SortList {

    @Test
    public void test() {

        ListNode head = new ListNode(8);
        head.next = new ListNode(6);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next = new ListNode(1);

        ListNode sortedHead = sortList(head);

        while (sortedHead != null) {
            System.out.print(sortedHead.val + "--> ");
            sortedHead = sortedHead.next;
        }

    }

    //    @Test
    public void testMerge() {
        ListNode sortedHead1 = new ListNode(1);
        sortedHead1.next = new ListNode(5);
        sortedHead1.next.next = new ListNode(9);
        sortedHead1.next.next.next = new ListNode(11);

        ListNode sortedHead2 = new ListNode(2);
        sortedHead2.next = new ListNode(4);
        sortedHead2.next.next = new ListNode(6);
        sortedHead2.next.next.next = new ListNode(10);

        ListNode head = mergeSortedLists(sortedHead2, sortedHead1);
//        ListNode head = mergeSortedLists(new ListNode(5), new ListNode(4));

        while (head != null) {
            System.out.print(head.val + "--> ");
            head = head.next;
        }
    }

    public ListNode sortList(ListNode head) {

        int length = getLength(head);

        if(length == 0) return head;

        ListNode sortedHead = mergeSort(head, length);
        return sortedHead;
    }

    public ListNode mergeSort(ListNode head, int length) {

        if (length <= 1) {
            head.next = null;
            return head;
        }

        if (length == 2) {
            //Order these 2 nodes
            if (head.val <= head.next.val) {
                head.next.next = null;
                return head;
            } else {
                ListNode newHead = head.next;
                newHead.next = head;
                newHead.next.next = null;
                return newHead;
            }
        }

        //split
        ListNode secondHead = head;
        int slideUntil = (length + 1) / 2;
        while (slideUntil > 0) {
            secondHead = secondHead.next;
            slideUntil--;
        }
        ListNode sortedFirstHead = mergeSort(head, (length + 1) / 2);
        ListNode sortedSecondHead = mergeSort(secondHead, length / 2);

        return mergeSortedLists(sortedFirstHead, sortedSecondHead);

    }

    public ListNode mergeSortedLists(ListNode h1, ListNode h2) {
        ListNode head = h1;
        ListNode prev1 = null;

        if (h1 != null && h2 != null && h1.val > h2.val) {
            return mergeSortedLists(h2, h1); //expect left head <= right head
        }
        while (h1 != null && h2 != null) {

            if (h1.val <= h2.val) {
                prev1 = h1;
                h1 = h1.next;
            } else {
                prev1.next = h2;//make link1
                prev1 = prev1.next;
                ListNode newH2 = h2.next;
                h2.next = h1; //make link2
                h2 = newH2;
            }
        }

        if (h1 == null) {
            prev1.next = h2;
        }

        return head;

    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
