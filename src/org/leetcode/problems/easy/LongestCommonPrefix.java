package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.Arrays;

public class LongestCommonPrefix {

    @Test
    public void test(){
        String[] strs = {"picture", "picasa", "pictoria"};

        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int N = strs.length;

        if(N==0){
            return "";
        }
        if(N==1){
            return strs[0];
        }
        if(N==2){
            prefix = longestCommonPrefixUtil(strs[0], strs[1]);
        } else {
            int mid = N/2;
            String[] firstHalf = Arrays.copyOfRange(strs, 0, mid);
            String[] secondHalf = Arrays.copyOfRange(strs, mid, N);
            String prefix1 = longestCommonPrefix(firstHalf);
            String prefix2 = longestCommonPrefix(secondHalf);
            prefix = longestCommonPrefixUtil(prefix1, prefix2);
        }

        return prefix;
    }

    public String longestCommonPrefixUtil(String str1, String str2){
        int i=0;
        String prefix = "";
        while (i < str1.length() && i < str2.length()){
            if(str1.charAt(i) == str2.charAt(i)){
                prefix += str1.charAt(i);
                i++;
            } else {
                break;
            }
        }
        return prefix;
    }
}
