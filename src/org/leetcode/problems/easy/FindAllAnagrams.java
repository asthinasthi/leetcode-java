package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

    @Test
    public void test(){

        String s= "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s,p);
        System.out.println(result);
    }

    public List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(s==null || p==null || s.length() == 0 || p.length() == 0) return result;
        int[] hash = new int[256];
        for(char c: p.toCharArray()){
            hash[c]++;
        }
        //sliding window
        int left =0, right = 0;
        int count = p.length();

        while(right < s.length()){
            if(hash[s.charAt(right)] >= 1){ //if char is in hash reduce count
                count--;
            }
            hash[s.charAt(right++)]--; //decrease count by default
            if(count == 0) result.add(left);

            if((right - left) == p.length() ){
                if(hash[s.charAt(left)] >= 0){ //hash existed & got used up
                    count++;
                }
                hash[s.charAt(left++)]++; //refill by one char amount
            }
        }
        return result;
    }

    public List<Integer> findAnagrams1(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int[] pMap = prepareMap(p);

        for(int i=0; i+p.length()<=s.length(); i++){
            int[] currMap = prepareMap(s.substring(i, i+p.length()));
            if(isAnagram(currMap, pMap)){
                result.add(i);
            }
        }
        return  result;
    }

    private int[] prepareMap(final String s){
        char[] charArr = s.toCharArray();
        int[] charMap = new int[256];

        for(char c: charArr){
            charMap[c]++;
        }
        return  charMap;
    }

    private boolean isAnagram(int[] a, int[] b){
        for(int i=0 ; i<a.length; i++){
            if (a[i] != b[i]){
                return false;
            }
        }
        return  true;
    }
}
