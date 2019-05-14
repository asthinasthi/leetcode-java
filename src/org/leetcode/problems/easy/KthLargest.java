package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.PriorityQueue;

public class KthLargest {

    public PriorityQueue<Integer> pq;
    public int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k, (a,b)->(b-a));
        for (int i = 0; i < nums.length; i++) {
            addToPQ(nums[i]);
        }
    }

    public int add(int val) {
        addToPQ(val);
        return pq.peek();
    }

    public void addToPQ(int val){
        if(pq.size() < k){
            pq.add(val);
        } else {
            if(pq.peek() > val){
                pq.poll();
                pq.add(val);
            }
        }
    }
}
