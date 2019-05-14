package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ThreeSumClosest {

    @Test
    public void test(){
//        int[] nums = new int[]{-1, 2, 1, -4};
//        int target = 1;
//        int[] nums = new int[]{1,1,1,0};
//        int target = -100;
//        int[] nums = new int[]{0,2,1,-3};
//        int target = 1;
        int[] nums = new int[]{1,1,-1,-1,3};
        int target = -1;
        System.out.println(threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        double minSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int start=i+1, end=nums.length-1;
            while (start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target){
                    end--;
                } else {
                    start++;
                }
                if(Math.abs(sum-target) < Math.abs(minSum-target)){
                    minSum = sum;
                }
            }
        }
        return (int)minSum;
    }

}
