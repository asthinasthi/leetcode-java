package org.leetcode.problems.hard;

import org.junit.Test;

public class ReverseKGroup {

    @Test
    public void test(){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode ans = reverseKGroup(head, 3);

        while (ans!=null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        Integer i = 0;
        ListNode curr = head;
        ListNode tail = null;

        while(curr!=null){
            i++;
            curr = curr.next;
            if(k-1==i){
                tail = curr;
                break;
            }
        }

        if(curr == null) return head;

        curr = head;
        ListNode prev = null;
        ListNode tailNext = tail.next;

        while(curr!=tailNext){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }