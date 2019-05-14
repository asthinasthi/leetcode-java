package org;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RokuTest1 {

    @Test
    public void test() {
        System.out.println(findMinWindow("ABC", "ADOBECODEBANC"));
    }

    public int findMinWindow(String t, String s) {
        Map<Character, Integer> tMap = new HashMap<>();
        int total = 0;
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            total++;
        }

        int begin = 0, end = 0, minLen = Integer.MAX_VALUE, N = s.length();

        while (end < N) {
            Character c = s.charAt(end);
            if (!tMap.containsKey(c)) {
                end++;
                continue;
            }
            int val = tMap.get(c);
            val--;
            tMap.put(c, val);
            if (tMap.get(c) >= 0) {
                total--;
            }

            while (total == 0) {
                minLen = Math.min(minLen, end - begin + 1);
                Character charAtBegin = s.charAt(begin);
                if (tMap.containsKey(charAtBegin)) {
                    tMap.put(charAtBegin, tMap.get(charAtBegin) + 1);
                    if (tMap.get(charAtBegin) > 0) {
                        total++;
                    }
                }
                begin++;
            }
            end++;
        }
        return minLen;
    }
}
