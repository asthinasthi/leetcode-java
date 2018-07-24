package org.leetcode.problems.easy;

import org.junit.Test;

public class SumTwoNumbers {

    @Test
    public void test(){
        System.out.println(getSum(4,5));
    }

    public int getSum(int a, int b) {

        while(b!=0){
            int carry = a&b;
            a = a^b;
            b = carry << 1;
        }
        return a;
    }
}
