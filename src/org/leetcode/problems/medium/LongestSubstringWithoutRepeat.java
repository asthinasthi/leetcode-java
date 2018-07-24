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
public class LongestSubstringWithoutRepeat {

	@Test
	public void test() {
		// String s = "dvdf";
		// String s = "aab";
		String s = "bpfbhmipx";
		// String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		// traverse the string comparing consecutive chars
		// keep storing str vs max length
		// if repeat research
		if (s == null) {
			return 0;
		}
		if (s.length() < 2) {
			return s.length();
		}

		char[] charArray = s.toCharArray();
		String longestSubStrSoFar = s.substring(0, 1);
		int position = 1;
		String tempStr = longestSubStrSoFar;
		while (position < s.length()) {
			if (!tempStr.contains(charArray[position] + "")) {
				tempStr += charArray[position];
			} else {
				// prev position
				if (charArray[position - 1] == charArray[position]) {
					tempStr = new String(charArray[position] + "");
				} else {// somewhere inside
					tempStr = tempStr.substring(tempStr
							.indexOf(charArray[position]) + 1)
							+ charArray[position];
				}
			}
			if (tempStr.length() > longestSubStrSoFar.length()) {
				longestSubStrSoFar = tempStr;
			}
			position++;
		}
		System.out.println(longestSubStrSoFar);
		return longestSubStrSoFar.length();
	}
}
