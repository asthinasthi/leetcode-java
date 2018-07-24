package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    @Test
    public void test(){
        int[] nums = new int[]{3,3,4};

        System.out.println(majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums){
           if(map.containsKey(n)){
               Integer val = map.get(n);
               map.put(n, ++val);
           } else {
               map.put(n, 1);
           }
        }

        for(int key: map.keySet()){
            if(map.get(key)>(nums.length)/2)
                return key;
        }
        return 0;
    }
}
