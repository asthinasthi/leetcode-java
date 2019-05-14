package org.leetcode.problems.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] results = new int[n-k+1];

        Deque<Integer> queue = new ArrayDeque<>();
        int numIdx = 0, resultIdx=0;
        while (numIdx<n){
            //out of range purge
            while (!queue.isEmpty() && queue.peek() < numIdx-k+1){
                queue.pollFirst();
            }

            //compare from back to max at top
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[numIdx]){
                queue.pollLast();
            }

            queue.offer(numIdx);
            //add for every i > k-1
            if (numIdx>=k-1){
                results[resultIdx++] = nums[queue.peekFirst()];
            }
            numIdx++;
        }
        return results;
    }
}
