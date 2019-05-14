package org.leetcode.problems.easy;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

public class ValidPalindromeII {

    @Test
    public void test() throws Exception {
        String s = "abaca";
        System.out.println(validPalindrome(s));
    }

    public boolean validPalindrome(String s){
        int i = 0;
        int j = s.length();
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j){
        while (i++ <= j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public boolean validPalindrome1(String s) {
        int begin = 0;
        int end = s.length()-1;
        boolean result1 = true;
        boolean result2 = true;
        boolean oneMove = false;
        while(begin <= end){
            if ((s.charAt(begin) == s.charAt(end))){
                begin++;
                end--;
                continue;
            } else {
                if(!oneMove){
                    begin++;
                    oneMove = true;
                }else{
                    result1 = false;
                    break;
                }
            }
        }

        oneMove = false;
        begin = 0;
        end = s.length()-1;
        while(begin <= end){
            if ((s.charAt(begin) == s.charAt(end))){
                begin++;
                end--;
                continue;
            } else {
                if(!oneMove){
                    end--;
                    oneMove = true;
                }else{
                    result2 = false;
                    break;
                }
            }
        }
        return result1 || result2;
    }
}
