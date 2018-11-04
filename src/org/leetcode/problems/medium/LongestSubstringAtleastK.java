package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestSubstringAtleastK {

    @Test
    public void test(){
//        String s = "ababbc";
//        String s = "ababacb";
//        String s = "aaabb";
        String s = "bbaaacbd";
        Integer k = 3;
        System.out.println(longestSubstring(s, k));
    }

    public int longestSubstring(String s, int k){
        if(s == null || s.length() == 0) return 0;

        int[] counts = new int[26];
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            counts[idx]++;
        }
        boolean flag=true;
        for(int i=0; i<s.length(); i++){
            if(counts[s.charAt(i)-'a']<k) { //atleast one char < k
                flag = false;
            }
        }

        if(flag) return s.length();

        int start = 0;
        int curr = 0;
        int max = 0;
        while(curr < s.length()){
            int charIdx = s.charAt(curr) - 'a';
            if(counts[charIdx] >0 && counts[charIdx] <k ){ //if a pivot
                max = Math.max(max, longestSubstring(s.substring(start, curr),k));
                start = curr + 1;
            }
            curr++;
        }
        max = Math.max(max, longestSubstring(s.substring(start), k));
        return max;
    }



}
