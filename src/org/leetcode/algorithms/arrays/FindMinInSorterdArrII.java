/**
 * 
 */
package org.leetcode.algorithms.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class FindMinInSorterdArrII {

	@Test
	public void test() {
		int[] nums = new int[]{3,4,5,6,0,1,2,3};
//		int[] nums = new int[]{1};
//		int[] nums = new int[]{-1,-1,-1,-1};
//		assertEquals(0, findMin(nums));
		assertEquals(0, findMinWORecursion(nums));
	}

	public int findMin(int[] nums){
		if(nums == null)
			return 0;
		if(nums.length == 0)
			return 0;
		
		return findMin(nums, 0, nums.length-1);
	
	}
	
	public int findMin(int[] nums, int startIdx, int endIdx){
		if(nums[startIdx] < nums[endIdx])
			return nums[startIdx];
		if(startIdx == endIdx)
			return nums[startIdx];
		
		return Math.min(findMin(nums, startIdx,startIdx+(endIdx-startIdx)/2), findMin(nums, startIdx+(endIdx-startIdx)/2+1, endIdx));
	}
	
	public int findMinWORecursion(int[] nums){
		int l = 0;
		int r = nums.length-1;
		int mid = (l+r)/2;
		
		while(l < r){
			if(nums[mid] < nums[r])
				r = mid;
			else if (nums[mid] > nums[r])
				l = mid+1;
			else
				r--;
		}
		
		return nums[l];
		
	}
	
}
