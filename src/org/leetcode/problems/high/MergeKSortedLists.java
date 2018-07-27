package org.leetcode.problems.high;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MergeKSortedLists {

    @Test
    public void test() {

        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode head = mergeKLists(lists);

        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

//    @Test
    public void mergeTwoListsTest(){
        ListNode[] lists = new ListNode[2];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        ListNode head = mergeTwoLists(lists[0], lists[1]);
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null)
            return null;

        int size = lists.length;

        if(size == 0){
            return null;
        }

        if(size == 1){
            return lists[0];
        }

        if(size == 2){
            return mergeTwoLists(lists[0], lists[1]);
        }

        ListNode[] list1 = Arrays.copyOfRange(lists, 0, (size+1)/2);
        ListNode[] list2 = Arrays.copyOfRange(lists, (size+1)/2, size);
        return mergeTwoLists(mergeKLists(list1), mergeKLists(list2));
    }

    // Always pass lower length first
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        ListNode head;

        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        if(l1.val <= l2.val){ //head at lower val
            head = l1;
        } else {
            head = l2;
            l2 = l1;
            l1 = head;
        }
        ListNode prev = head;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                ListNode newL2Head = l2.next;//new l2 head
                l2.next = l1;
                prev = l2;
                l2 = newL2Head;
            }
        }

        if(l1 == null){
            prev.next = l2;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
