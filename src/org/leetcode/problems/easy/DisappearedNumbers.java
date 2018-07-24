package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DisappearedNumbers {

    @Test
    public void test(){
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> results = findDisappearedNumbers(nums);
        String s = "";
        for (Integer result : results) {
            s += result.toString();
        }
        System.out.println(s);
    }

    // nums = [2,3,4,4,6]
    // o/p = [1,2]
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> results = new ArrayList<Integer>();
        for(int i=0;i<nums.length; i++){
            results.add(i+1);
        }

        for(int i=0; i< nums.length; i++){
            results.set(nums[i]-1, 0);
        }

        int lastNonZero =0;
        int mover = 0;
        while(lastNonZero < results.size() && mover < results.size()){
            if(results.get(mover) != 0){
                results.set(lastNonZero, results.get(mover));
                lastNonZero++;
            }
            mover++;
        }

        return results.subList(0, lastNonZero);
    }
}
