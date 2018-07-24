package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeroes {
    @Test
    public void test(){
//        int[] nums = new int[]{1,2,3,4,5,6};
//        int[] nums = new int[]{1,2,3,0,0,0,4,5,6};
        int[] nums = new int[]{0};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int zeroBeginIdx = nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0 && i<zeroBeginIdx){
                zeroBeginIdx = i;
            } else if(nums[i]!=0 && zeroBeginIdx < i) {
                nums[zeroBeginIdx] = nums[i];
                nums[i]=0;
                zeroBeginIdx++;
            }
        }
    }
}
