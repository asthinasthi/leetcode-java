package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.*;

public class WordBreak {

    @Test
    public void test(){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(wordBreakDP(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordDict){
            set.add(word);
        }
        return wordBreakUtil(s, set);
    }

    public boolean wordBreakUtil(String s, HashSet<String> set ){
        boolean result = false;
        if(s.isEmpty()) return true;
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext() && !result){
            String dict = iterator.next();
            if(s.indexOf(dict) == 0){
                String pendingStr = s.substring(dict.length());
                result = true && wordBreakUtil(pendingStr, set);
            }
        }
        return result;
    }

    public boolean wordBreakDP(String s, List<String> wordDict){
        Set<String> set = new HashSet<>();
        for(String word: wordDict)
            set.add(word);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < s.length()+1 ; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i)) ){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
