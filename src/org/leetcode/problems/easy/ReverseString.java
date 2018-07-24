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
public class ReverseString {

	@Test
	public void test() {
		String s = "Hello";
		System.out.println(reverseString(s).toString());
	}
	
    public String reverseString(String s) {
        char[] strArray = s.toCharArray();
        
        int low = 0;
        int high = strArray.length-1;
        
        while(low<high){
        	char t = strArray[low];
        	strArray[low] = strArray[high];
        	strArray[high] = t;
        	low++;
        	high--;
        }
        return new String(strArray);
    }
}
