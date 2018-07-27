package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.List;

public class MergeSort {

    @Test
    public void test(){

        ListNode l1 = new ListNode(1);
         l1.next = new ListNode(3);
         l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode head = mergeTwoLists(l1, l2);

        while (head!=null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        if(l1 == null) return l2;

        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
