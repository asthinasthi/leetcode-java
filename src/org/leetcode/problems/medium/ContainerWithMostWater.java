package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.Stack;

public class ContainerWithMostWater {

    @Test
    public void test(){
//        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        int[] heights = new int[]{1,2,1};
//        int[] heights = new int[]{2,3,10,5,7,8,9};
//        int[] heights = new int[]{1,2,4,3};
        System.out.println(maxArea(heights));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        if(height.length <2) return maxArea;

        int begin = 0, end = height.length-1;

        while (begin < end){
            if(height[begin] < height[end]){
                maxArea = Math.max(maxArea, height[begin]*(end-begin));
                begin++;
            } else {
                maxArea = Math.max(maxArea, height[end]*(end-begin));
                end--;
            }
        }

        return maxArea;
    }
}
