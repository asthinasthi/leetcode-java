package org.leetcode.problems.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

//Only unique occurence will be provided
public class TwoSum {
	
	@Test
	public void test(){
		
		int[] nums = new int[]{0, 4, 3, 0};
		int target = 0;
		int[] results = twoSum(nums, target);
		for(int result : results)
			System.out.println(result);
	}
	public int[] twoSum(int[] nums, int target){
		if(nums == null)
			return null;
		int[] result = new int[2];
		for(int leftPtr=0; leftPtr<nums.length-1; leftPtr++){
			for(int rightPtr=leftPtr+1; rightPtr < nums.length; rightPtr++){
				if(nums[leftPtr]+nums[rightPtr] == target){
					result[0] = leftPtr;
					result[1] = rightPtr;
				}
			}
		}
		return result;
	}
}
