package org.leetcode.problems.hard;

import org.junit.Test;

public class BurstBalloons {

    @Test
    public void test(){
    int[] nums = new int[]{3,1,5,8};
    int result = maxCoins(nums);
        System.out.println(result);
    }

    public int maxCoins(int[] nums){
        int[] paddedNums = new int[nums.length+2];
        paddedNums[0] = 1;
        for(int i=0; i<nums.length; i++){
            paddedNums[i+1] = nums[i];
        }
        paddedNums[nums.length+1] = 1;

        int[][] dp = new int[paddedNums.length][paddedNums.length];
        for (int i=0; i<paddedNums.length; i++){
            dp[i][i]=paddedNums[i];
        }

        /*
        * k is the last balloon to be burst in the range i,j
        * Try all possible k's in the range i,j
        * len can vary from 1 --> N. Traverse every i,j in all the length
        * i,j can range from 0,1 0,2 1,2 3,4 ... 0,n
        * */

        for(int len=1; len<=nums.length; len++){ //padded at the end
            for(int i=1; i<=nums.length-len+1; i++){
                int j = i + len -1;
                for(int k=i; k<=j ; k++){
                    int calcVal = paddedNums[i-1]*paddedNums[k]*paddedNums[j+1] + dp[i][k-1] + dp[k+1][j];
                    dp[i][j] = Math.max(calcVal, dp[i][j]);
                }
            }
        }

        return dp[1][nums.length];
    }

}
