package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.HashMap;

public class AtMostKDistinctChars {

    @Test
    public void test(){
        String s = "abcede";
//        String s = "abaccc";
        int k = 4;
        int ans = lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(ans);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int distinctCount = 0;
        int maxLength = 0;
        int N = s.length();
        if(k==0) return 0;
        HashMap<String, Integer> map = new HashMap<>();

        int i=0,j=0;
        while(i<N && j<N){
            String key = s.substring(j,j+1);

            if(map.containsKey(key)){
                int val = map.get(key);
                val++;
                map.put(key, val);
            } else {
                if(distinctCount < k ){ //reached k
                    map.put(key, 1);
                    distinctCount++;
                } else {
                    reduceKey(map, s.substring(i,i+1));
                    distinctCount = map.keySet().size();
                    i++;
                    continue;
                }
            }
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return maxLength;
    }

    public void reduceKey(HashMap<String, Integer> map, String key){
        Integer val = map.get(key);
        if(val == 1){
            map.remove(key);
        } else {
            map.put(key, --val);
        }
    }
}
