/**
 * 
 */
package org.leetcode.problems.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class NumberOfBitsInInt {

	@Test
	public void test() {
//		assertEquals(32, hammingWeight( -2147483647  ));
		int n = -0;
		System.out.println(Integer.toBinaryString(0));
		try {
			System.out.println(Integer.parseInt("10000000000000000000000000000000", 2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(32, hammingWeight( -0));
	}

	public int hammingWeight(int n){
		int ones = 0;
		while(n!=0){
			ones+=n&1;
			n=n>>>1;
		}

		return ones;
	}
}
