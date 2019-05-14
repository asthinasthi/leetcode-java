package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.HashMap;

public class LRUCacheSolution {

    @Test
    public void test(){

        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    public class LRUCache{
        HashMap<Integer, LinkedList> ptrMap = new HashMap<Integer, LinkedList>();

        LinkedList head = null;
        LinkedList tail = null;
        int capacity;


        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            //if key exists move to front of the list --> remove last element
            if(ptrMap.containsKey(key)){
                cachify(key);
                return ptrMap.get(key).val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if(capacity < 1){
                return;
            }

            if(head == null){
                head = new LinkedList(key, value);
                tail = head;
                ptrMap.put(key, head);
            } else {
                //move head
                LinkedList curr;

                //trim tail ?
                if (ptrMap.containsKey(key)) {
                    curr = ptrMap.get(key);
                    curr.val = value;
                    cachify(key);
                } else {
                    curr = new LinkedList(key, value);
                    curr.next = head;
                    head.prev = curr;
                    head = curr;
                    ptrMap.put(key, curr);
                    if (ptrMap.keySet().size() > capacity) {
                        trimTail();
                    }
                }
            }
        }

        public void cachify(int key){
            // is Head
            if(head.key == ptrMap.get(key).key){
                return;
            }

            //is Tail
            if(tail.key == key){
                LinkedList tailMinusOne = tail.prev;
                tail.next = head;
                head.prev = tail;
                head = tail;
                tail = tailMinusOne;
                return;
            }
            // Non Tail
            LinkedList curr = ptrMap.get(key);
            LinkedList currMinusOne = curr.prev;
            LinkedList currPlusOne = curr.next;
            currMinusOne.next = currPlusOne;
            currPlusOne.prev = currMinusOne;
            curr.next = head;
            head.prev = curr;
            head = curr;
            head.prev = null;

            if(ptrMap.keySet().size() > capacity){ // need to trim the tail
                trimTail();
            }

        }

        public void trimTail(){
            LinkedList tailPtr = tail;
            //remove from hashmap
            ptrMap.remove(tail.key);

            //move tail one step back
            tail = tailPtr.prev;
            tail.next = null;
        }

        class LinkedList{
            LinkedList prev;
            LinkedList next;
            int key;
            int val;

            public LinkedList(int key, int val){
                this.key = key;
                this.val = val;
            }
        }

    }

}
