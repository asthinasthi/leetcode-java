/**
 * 
 */
package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class NextNumber {

	@Test
	public void test() {
		int nums[] = {4,2,0,2,3,2,0};
//		for(int num: nextPermutation(nums))
//			System.out.print(num+" ");
	}

	public void nextPermutation(int[] nums) {
		if(nums.length < 2){
			return ;
		}
		//find first dip
		int idx = nums.length-1;
		
		while(idx>0){
			if(nums[idx] > nums[idx-1]){
				break;
			}
			idx--;
		}
		
		if(idx == 0){// reverse
			reverse(nums, 0);
			return;
		}
		int jdx = nums.length-1;
		int dip = nums[idx-1];
		int dipIdx = idx-1;
		while(jdx > dipIdx){
			if(nums[jdx] > dip){
				nums[dipIdx] = nums[jdx];
				nums[jdx] = dip;
				break;
			}
			jdx--;
		}
		reverse(nums, dipIdx+1);
//		return;
    }
	
	private void reverse(int[] nums, int i){
		int first = i;
		int last = nums.length-1;
		
		while(first < last){
			int temp = nums[first];
			nums[first] = nums[last];
			nums[last] = temp;
			first++;
			last--;
		}
	}
	
//	@Test
	public void sortTest(){
		int nums[] = {5, 8, 6};
		Arrays.sort(nums, 1, 3);
		for (int num : nums)
		System.out.print(num + " ");
	}
}
