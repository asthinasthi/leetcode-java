package org.leetcode.problems.easy;

import org.junit.Test;

public class SingleNumber {

    @Test
    public void test(){

//        int[] nums = new int[]{1,1, 2,2, 3, 4,4, 5,5, 7,7};
        int[] nums = new int[]{2};
        System.out.println(singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i: nums){
            xor = xor ^ i;
        }
        return xor;
    }
}
