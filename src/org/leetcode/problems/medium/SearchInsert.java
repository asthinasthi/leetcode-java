/**
 * 
 */
package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class SearchInsert {

	@Test
	public void test() {
    	int[] nums = {1,2};
    	int target = 3;
    	int resultIdx = searchInsert(nums, target);
    	System.out.println(resultIdx);
    	assertEquals(2, resultIdx);
	}
	
    public int searchInsert(int[] nums, int target) {
//    	return binarySearch(nums, 0, nums.length-1, target);
    	return binarySearchWithoutRecursion(nums, target);
    }
    
    private int binarySearchWithoutRecursion(int[] nums, int target){
    	int low = 0;
    	int high = nums.length - 1;
    	while(low<=high){
        	int mid = low + (high-low)/2;
    		if(nums[mid] == target){
    			return mid;
    		} else if (target < nums[mid]){
    			high = mid-1;
    		} else {
    			low = mid+1;
    		}
    	}
    	return low;
    }
    
    private int binarySearch(int[] nums, int low, int high, int target){
    	if(low == high){
    		if(target == nums[low])
    			return 0;
    		else if(target < nums[low])
    			return 0;
    		else//target > nums[low]
    			return 1;
    	}
    	
    	int midIdx = low + (high-low)/2;
    	if(target == nums[midIdx]){
    		return midIdx;
    	}
    	
    	if(target < nums[midIdx]){
    		high = midIdx-1;
    		if(low > high)
    			return 0;
    		return high - binarySearch(nums, low, high, target);
    	} else {
    		low = midIdx + 1;
    		return low + binarySearch(nums, low, high, target);
    	}
    }
}
