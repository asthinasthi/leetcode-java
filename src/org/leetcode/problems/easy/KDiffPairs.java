package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairs {

    @Test
    public void test(){
//        int[] nums = new int[]{1,3,1,5,4};
//        int k = 0;
        int[] nums = new int[]{1,2,3,4,5};
        int k = -1;
//        int[] nums = new int[]{3,1,4,1,5};
//        int k = 2;
        System.out.println(findPairs(nums, k));
    }

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        if(k<0) return 0;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int val = map.get(nums[i]);
                map.put(nums[i], ++val);
            } else {
                map.put(nums[i],1);
            }
        }

        Map<Integer, Integer> keyPair = new HashMap<>();
        if(k == 0){
            for(int key: map.keySet()){
                if(map.get(key) > 1){
                    pairs++;
                }
            }
        } else {
            for(int key: map.keySet()){
                int num1 = k+key; // key is always lower
                if(map.containsKey(num1)){
                    pairs++;
                }
            }
        }

        return pairs++;
    }
}
