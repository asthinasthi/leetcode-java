package org.leetcode.problems.hard;

import org.junit.Test;

public class TrappingRainWater {

    @Test
    public void test(){
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = new int[]{0,1,0,2,1,0,1,3};
//        int[] height = new int[]{4,2,3};
        int result = trap(height);
        System.out.println(result);
    }

    public int trap(int[] height) {
        if(height.length <= 1)
            return 0;
        int water = 0;
        int beginIdx = 0;
        int beginHt = 0;
        int maxIdx = findMaxIdx(height);
        //forward
        for(int i=1; i<=maxIdx; i++){
            beginHt = height[beginIdx];
            if(height[i] >= beginHt ){
                beginIdx = i;
            } else {
                water += beginHt - height[i];
            }
        }

        //backward
        beginHt = height[height.length-1];
        beginIdx = height.length-1;
        for(int i=height.length-2;i>=maxIdx;i--){
            beginHt = height[beginIdx];
            if(height[i] >= beginHt ){
                beginIdx = i;
            } else {
                water += beginHt - height[i];
            }
        }
        return water;
    }

    public int findMaxIdx(int[] height){
        int maxIdx = 0;
        for(int i=0; i< height.length; i++){
            if(height[i] >= height[maxIdx]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
