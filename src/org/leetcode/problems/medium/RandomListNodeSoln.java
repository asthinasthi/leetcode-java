package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomListNodeSoln {

    @Test
    public void test(){
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(-1);

        RandomListNode headCopy = copyRandomList(head);
        System.out.println(headCopy.label);
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if(head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode head1 = head,head2 = head;
        RandomListNode headCopy = new RandomListNode(0);
        RandomListNode headCopy1 = headCopy;
        while (head1!=null){
            headCopy.label = head1.label;
            map.put(head1, headCopy);
            if(head1.next!=null){
                headCopy.next = new RandomListNode(0);
            }
            head1 = head1.next;
            headCopy = headCopy.next;
        }

        while (head2!=null){
            RandomListNode hCopy = map.get(head2);
            if(head2.random!=null){
                hCopy.random = map.get(head2.random);
            }
            head2 = head2.next;
        }

        return headCopy1;
    }

    public void print(RandomListNode head){
        RandomListNode headTemp = head;
        while (headTemp!=null){
            System.out.println("Label:" +  headTemp.label);
            if(headTemp.random!=null)
                System.out.println("Rand:" +  headTemp.random.label);
            else
                System.out.println("Rand: NULL");
            headTemp = headTemp.next;
        }
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
