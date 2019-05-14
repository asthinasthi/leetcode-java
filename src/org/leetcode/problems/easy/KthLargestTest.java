package org.leetcode.problems.easy;

import org.junit.Test;

public class KthLargestTest {

    @Test
    public void test(){
        int[] nums = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
    }
}
