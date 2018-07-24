package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    @Test
    public void test(){

        String s = "aabbc";
        System.out.println(firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        //if none zero
        int [] occurenceMap = new int[256];

        for(char c: s.toCharArray()){
            occurenceMap[c]++;
        }

        for (char c: s.toCharArray()){
            if(occurenceMap[c] == 1){
                return s.indexOf(c);
            }
        }
        return -1;
    }
}
