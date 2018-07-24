package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingBits {

    @Test
    public void test(){
//        System.out.println(isPowerOfTwo(16));

        int[] results = countBits(10);
        System.out.println(results);
    }

    public int[] countBits(int num) {
        int[] ones = new int[num+1];
        ones[0] = 0;
        ones[1] = 1;
        int nearestPow = 0;

        for(int i=2; i<= num; i++){
            if(isPowerOfTwo(i)){
                ones[i] = 1;
                nearestPow = i;
            } else {
                ones[i] = 1 + ones[i-nearestPow];
            }
        }
        return ones;
    }

    public boolean isPowerOfTwo(int num){
        return  num > 0 && ((num & num-1) ==0);
    }
}
