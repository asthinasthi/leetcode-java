package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    @Test
    public void test(){
//        String paragraph = "Bob hit a ball! the hit BALL flew far after it was hit.";
//        String[] banned = new String[]{"hit"};

        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = new String[]{"a"};
        System.out.println(mostCommonWord(paragraph, banned));
    }


    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        bannedSet.add("");
        for (int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i]);
        }

        String mostCommonWord = "";
        String[] tokens = paragraph.split("[ ,]");
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < tokens.length; i++) {
            String key = tokens[i];
            key = key.toLowerCase();
            key = key.replaceAll("[^(a-z)]", "");
            if(!bannedSet.contains(key)){
                int val = map.getOrDefault(key,0)+1;
                map.put(key, val);

                if(val>max){
                    max = val;
                    mostCommonWord = key;
                }
            }
        }

        return mostCommonWord;
    }
}
