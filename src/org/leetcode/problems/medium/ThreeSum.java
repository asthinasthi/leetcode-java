package org.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
public class ThreeSum {

	@Test
	public void test(){
		int[] nums = new int[]{-1 ,0 ,1 ,2 ,-1 ,-4};
//		int[] nums = new int[]{0,0,0};
		List<List<Integer>> results = threeSum(nums);
		for(List list: results)
			System.out.println(list.toString());
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results;
		HashSet<List<Integer>> resultsSet = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		int N = nums.length;
		// For every element in the array find corresponding sum
		for (int leftPtr = 0; leftPtr < N-2; leftPtr++) {
			// find two sum
			int sum = -nums[leftPtr];
			int midPtr = leftPtr+1;
			int rightPtr = N-1;
			while(midPtr < N && rightPtr>leftPtr && midPtr < rightPtr){
				if(nums[midPtr] + nums[rightPtr] > sum){
					rightPtr--;
				} else if (nums[midPtr] + nums[rightPtr] < sum){
					midPtr++;
				} else {
					List<Integer> someList = new ArrayList<Integer>();
					someList.add(nums[leftPtr]);
					someList.add(nums[midPtr]);
					someList.add(nums[rightPtr]);
					resultsSet.add(someList);
					rightPtr--;
					midPtr++;
				}
			}

		}
		results = new ArrayList<List<Integer>>(resultsSet);
		return results;
	}
	
	public List<List<Integer>> twoSum(int[] nums, int sum){
		List<List<Integer>> results;
		HashSet<List<Integer>> resultsSet = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		int N = nums.length;
		int leftPtr = 0;
		int rightPtr = N-1;
		while(leftPtr < N && rightPtr>0 && leftPtr < rightPtr){
			if(nums[leftPtr] + nums[rightPtr] > sum){
				rightPtr--;
			} else if (nums[leftPtr] + nums[rightPtr] < sum){
				leftPtr++;
			} else {
				List<Integer> someList = new ArrayList<Integer>();
				someList.add(nums[leftPtr]);
				someList.add(nums[rightPtr]);
				resultsSet.add(someList);
				rightPtr--;
				leftPtr++;
			}
		}
		results = new ArrayList<List<Integer>>(resultsSet);
		return results;
	}
}
