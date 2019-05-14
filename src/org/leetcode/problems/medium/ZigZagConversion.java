package org.leetcode.problems.medium;

import org.junit.Test;

public class ZigZagConversion {

    @Test
    public void test(){
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));

//        String s = "ABCDE";
//        System.out.println(convert(s, 4));

    }

    public String convert(String s, int numRows) {
        StringBuffer[] stringBuffers = new StringBuffer[numRows];
        for(int i=0; i<numRows; i++){
            stringBuffers[i] = new StringBuffer();
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        int N=s.length();

        while (i<N){
            for(int row=0; row<numRows && i<N; row++){
                stringBuffers[row].append(s.charAt(i++));
            }
            for(int row=numRows-2; row>0 && i<N; row--){
                stringBuffers[row].append(s.charAt(i++));
            }
        }

        for(int row=0; row<numRows; row++){
            sb.append(stringBuffers[row]);
        }
        return sb.toString();
    }
}
