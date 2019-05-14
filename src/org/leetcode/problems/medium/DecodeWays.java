package org.leetcode.problems.medium;

import org.junit.Test;

public class DecodeWays {

    @Test
    public void test(){
        String s = "230";
        System.out.println(numDecodings(s));
    }

    private int getCount(String str){
        Integer strInt = Integer.parseInt(str);

        if(str.length() == 1){
            return strInt == 0 ? 0: 1;
        }

        if(strInt<10) return 0; //05 case

        if(strInt > 26 && strInt%10!=0){
            return 1;
        } else if(strInt >26 && strInt%10 == 0){
            return 0;
        } else if(strInt == 10 || strInt == 20) {
            return 1;
        } else {
            return 2;
        }
    }

    public int numDecodings(String s) {
        int[][] numDecodings = new int[s.length()][s.length()];

        for(int i=0; i<s.length(); i++){
            numDecodings[i][i] = getCount(s.substring(i,i+1));
        }

        for(int i=0; i<s.length()-1; i++){
                numDecodings[i][i+1] = getCount(s.substring(i,i+2));
        }

        for (int i = s.length()-3; i >=0 ; i--) {

            int first = numDecodings[i][i]*numDecodings[i+1][s.length()-1];
            if(first > 0){
                numDecodings[i][s.length()-1] = first + (numDecodings[i][i+1]-1)*numDecodings[i+2][s.length()-1];
            } else {
                numDecodings[i][s.length()-1] = first + numDecodings[i][i+1]*numDecodings[i+2][s.length()-1];
            }

        }

        return numDecodings[0][s.length()-1] >= 0 ? numDecodings[0][s.length()-1]:0;
    }
}
