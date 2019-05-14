package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LongestSubstring2Distinct {

    @Test
    public void test() {
        String s = "eceba";
        s = "ccaabbb";
        s = "aaaa";
        s = "abaccc";
//        s = "aac";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() <= 2) return s.length();

        char[] characters = s.toCharArray();
        int h1 = 0, h2 = 0, begin = 0, end = 0, length = 0;

        while (end < s.length()) {
            if (characters[end] != characters[h1] && characters[end] != characters[h2]) {
                if(characters[h1] == characters[h2]){
                    h1 = end-1;
                    h2 = end;
                } else {
                    begin = Math.min(h1, h2) + 1;//end check
                    h1 = Math.max(h1, h2);
                    h2 = end;
                }
            } else if (characters[end] == characters[h1]) {
                h1 = end;
            } else if (characters[end] == characters[h2]) {
                h2 = end;
            }
            length = Math.max(length, end - begin + 1);
            end++;
        }
        return length;
    }
}
