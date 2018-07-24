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
public class SearchRange {

	@Test
	public void test() {
		int[] nums = {1};
		int target = 1;
		for(int range: searchRange(nums, target))
			System.out.print(range + " ");
	}

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int[] range = {-1, -1};
        
        while(low <= high){
        	int mid = low + (high-low)/2;
        	if(target < nums[mid]){
        		high = mid-1;
        	} else if (target == nums[mid]){
        		int[] rangeFound = {mid, mid};
        		int left = mid;
        		int right = mid;
        		while(left >= 0 || right <= nums.length-1){
           	
        			if(left>=0 && nums[left] == target){
        				rangeFound[0] = left;
        			}
    				if(right<=nums.length-1 && nums[right] == target){
    					rangeFound[1] = right;
        			}
    				left--;
    				right++;
        		}
        		return rangeFound;
        	} else {
        		low = mid+1;
        	}
        }
        return range;
    }
}
