package org.leetcode.problems.easy;

import org.junit.Test;

public class ReadNChars {

    @Test
    public void test(){
        int count = 0;
        System.out.println(3<4);
    }
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int count = 0;
        int total = 0;
        boolean eof = false;
        while(!eof && total < n){
            count = read4(temp);
            eof = count<4;
            count = Math.min(count, n-total);
            for(int i=0; i<count; i++){
                buf[total++] = temp[i];
            }
        }
        return total;
    }

    public int read4(char[] temp){
        return 0;
    }
}
