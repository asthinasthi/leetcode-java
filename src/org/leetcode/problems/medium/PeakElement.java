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
public class PeakElement {

	@Test
	public void test() {
		int[] nums = {1,2,1,3,1};
		assertEquals(3, findPeakElement(nums));
	}

    public int findPeakElement(int[] nums) {
    		int start = 0;
    		int end = nums.length-1;
    		
    		return helperFunc(nums, start, end);
    }
    
    public int helperFunc(int[] nums , int start, int end){
    	if(nums.length <= 2){
    		if(nums[start] < nums[end]){
    			return end;
    		}else{
    			return start;
    		}
    	}
    	int m = start + (end-start)/2;
    	
    	if(nums[m-1] < nums[m] && nums[m] < nums[m+1]){
    		return m;
    	} else if (nums[m-1] < nums[m]){
    		return helperFunc(nums, start, m);
    	} else {
    		return helperFunc(nums, m+1, end);
    	}
    }
}
