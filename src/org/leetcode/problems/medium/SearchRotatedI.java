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
public class SearchRotatedI {

	@Test
	public void test() {
//		int[] nums = {5,4,3,0,1,2};
//		System.out.println(findMin(nums));
		int[] nums = {3,5,1};
		int target = 3;
		System.out.println(search(nums, target));
	}

	public int search(int[] nums, int target){
		int minIdx = findMin(nums);
		int low = 0;
		int high = nums.length-1;
		if(nums.length < 2){
			if(target == nums[0]){
				return 0;
			} else {
				return -1;
			}
		}
		
		if(minIdx == 0){
			return binarySearch(nums, low, high, target);
		}
		
		if(target >= nums[minIdx] && target <= nums[high]){
			return binarySearch(nums, minIdx, high, target);
		} else if(target >= nums[low] && target <= nums[minIdx-1]){
			return binarySearch(nums, low, minIdx-1, target);
		} else 
		return -1;
	}
	
	public int binarySearch(int[] nums, int low, int high, int target){
		while(low <= high){
			int mid = (low+high)/2;
			if(target==nums[mid]){
				return mid;
			}
			if(target<nums[mid]){
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return -1;
	}
	
	public int findMin(int[] nums){
		int low =0;
		int high = nums.length-1;
		while(low < high){
			int mid = (low+high)/2;
			if(nums[mid] <= nums[high]){
				high = mid;
			}else{
				low = mid+1;
			}
		}
		return low;
	}
	
	/*public int search(int[] nums, int target) {
	    int minIdx = findMinIdx(nums);
	    if (target == nums[minIdx]) return minIdx;
	    int m = nums.length;
	    int start = (target <= nums[m - 1]) ? minIdx : 0;
	    int end = (target > nums[m - 1]) ? minIdx : m - 1;

	    while (start <= end) {
	        int mid = start + (end - start) / 2;
	        if (nums[mid] == target) return mid;
	        else if (target > nums[mid]) start = mid + 1;
	        else end = mid - 1;
	    }
	    return -1;
	}

	public int findMinIdx(int[] nums) {
	    int start = 0, end = nums.length - 1;
	    while (start < end) {
	        int mid = start + (end -  start) / 2;
	        if (nums[mid] > nums[end]) start = mid + 1;
	        else end = mid;
	    }
	    return start;
	}*/
}
