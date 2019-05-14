package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.Arrays;

public class LongestPalindrome {

    @Test
    public void test(){
//        String s = "ababad";
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        String s = "cbbd";
//        String s = "ccc";
//        String output = longestPalindromeDP(s);
        System.out.println(longestPalindrome(s));
    }

    public String longestPalindromeDP(String s) {
        if(s == null || s.length() == 0)
            return "";

        int N = s.length();
        boolean[][] p = new boolean[N][N];

        for (int i=0; i<N; i++){
            p[i][i] = true;
        }
        int maxLen = 1;
        int maxStart = 0;

        //2 len
        for(int i=0; i<N-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                p[i][i+1] = true;
                if(maxLen == 1){
                    maxStart = i;
                    maxLen = 2;
                }
            }
        }


        for(int len=3; len<=N; len++){
            for(int i=0; i<=N-len; i++){
                int j=i+len-1;
                p[i][j] = p[i+1][j-1] && s.charAt(i) == s.charAt(j);
                if(len > maxLen && p[i][j]){
                    maxLen = len;
                    maxStart = i;
                }
            }
        }

        return s.substring(maxStart, maxStart+maxLen);
    }

    public String longestPalindrome(String s){
        int N = s.length();
        boolean[][] isPalindrome = new boolean[N][N];
        int begin=0,end=0,maxLen=-1;

        for (int i = 0; i < N; i++) {
            isPalindrome[i][i] = true;
        }

        for(int i=0; i<N-1; i++){
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if(isPalindrome[i][i+1]){
                begin = i; end = i+1; maxLen = 2;
            }
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N; j++) {
                if(j-i>1){
                    if(s.charAt(i) == s.charAt(j)){
                        isPalindrome[i][j] = isPalindrome[i+1][j-1];
                        if(j-i+1>maxLen && isPalindrome[i][j]){
                            end = j; begin =i; maxLen = j-i+1;
                        }
                    } else {
                        isPalindrome[i][j] = false;
                    }
                }
            }
        }

        return s.substring(begin, end+1);
    }

}
