package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SubArraySum {

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;

//        nums = new int[]{1, 2, 1, 2, 1};
//        k = 3;
//
//        nums = new int[]{1, 2, 3};
//        k = 3;
//
//        nums = new int[]{1};
//        k = 0;
//
//        nums = new int[]{-1, -1, 1};
//        k = 0;
        System.out.println(subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int maxLen = 0;
        Map<Integer, Integer> sumIdxMap = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum == k){
                maxLen = Math.max(maxLen,i+1);
            } else if(sumIdxMap.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i-sumIdxMap.get(sum-k));
            }

            if(!sumIdxMap.containsKey(sum)){
                sumIdxMap.put(sum, i);
            }
        }
        return maxLen;
    }
}
