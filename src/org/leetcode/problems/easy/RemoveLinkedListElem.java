package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

public class RemoveLinkedListElem {

    @Test
    public void test(){
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        ArrayList<String> names = new ArrayList<>();
        names.add("Anirudh");
        names.add("Mathad");
        names.add("Stephan");
        names.add("Hawking");

        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
              s = s.replaceAll("a", "Alpha");
                System.out.println(s);
            }
        });


//        ListNode head = new ListNode(1);
//        ListNode head1 = removeElements(head, 1);
//
//        while (head1!=null){
//            System.out.print(head1.val + " ");
//            head1 = head1.next;
//        }

    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        while(head!=null && head.val == val) head = head.next;

        ListNode curr = head;
        while (curr!=null && curr.next!=null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        ListNode prev = curr;
        if(curr!=null && curr.val == val) prev.next = null;
        return head;
    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
