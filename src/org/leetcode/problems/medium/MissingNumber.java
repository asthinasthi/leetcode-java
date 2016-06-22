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
public class MissingNumber {

	@Test
	public void test() {
		int[] nums = {0,1,2,4};
		System.out.println(missingNumber(nums));
	}

    public int missingNumber(int[] nums) {
    	int originalXor = 0;
        for(int i=0; i <=nums.length; i++){
        	originalXor ^= i;
        }
        int currentXor = 0;
        for(int num: nums){
        	currentXor ^= num;
        }
        
        return originalXor^currentXor;
    }
}
