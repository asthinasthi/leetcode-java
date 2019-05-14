package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.*;

public class MinWindowSubstring {

    @Test
    public void test() {
        String s = "ADOBECODEBANC", t = "ABC";
        s = "ADOBBECODE"; t = "ABC";
//        s = "aa"; t="aa";
//        s = "ab"; t="b";
//        s = "abc"; t="b";
//        s = "bbaac"; t="aba";
//        s="cabwefgewcwaefgcf";t="cae";
        System.out.println(minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        String ret = "";
        Map<Character, Integer> tMap = new HashMap<>(), winMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int l = 0, minL = 0, count = 0; //check if contained in tMap and count matches?
        int minLen = Integer.MAX_VALUE;
        for (int h = 0; h < s.length(); h++) {
            Character c = s.charAt(h);
            if (tMap.containsKey(c)) { //exists
                tMap.put(c, tMap.get(c) - 1);
                if (tMap.get(c) >= 0) {
                    count++;  // won't increase count for AxyzBB . bcos map of B will be <0
                }
//count == t.length only if the occurences match
                while (count == t.length()) {
                    if (h - l + 1 < minLen) {
                        minLen = h - l + 1;
                        minL = l;
                    }

                    if (tMap.containsKey(s.charAt(l))) {
                        tMap.put(s.charAt(l), tMap.get(s.charAt(l)) + 1);
                        if (tMap.get(s.charAt(l)) > 0) { //only decrease counter if count >0
                            count--;
                        }
                    }
                    l++;
                }
            }
        }

        if (minLen > s.length()) {
            return "";
        }

        ret = s.substring(minL, minL + minLen);
        return ret;
    }
}
