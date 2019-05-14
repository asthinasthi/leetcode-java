package org.leetcode.problems.easy;

import org.junit.Test;

public class ExcelSheetColNum {

    @Test
    public void test(){
        //ZY --> 701 ? 26 + 27
        // AA --> 1x26 + 1
        // ZY --> 26x26 + Y
//        System.out.println(titleToNumber("ZY"));

        Integer a = 16;
        Integer b = 17;

        int carry1 = a&b;
        int sum1 = a^b;

        System.out.println(carry1);
        System.out.println(sum1);

        carry1 = carry1<<1;
        int sum2 = sum1^carry1;
        System.out.println(sum2);
    }

    public int titleToNumber(String s) {
        int colNum = 0;
        int N = s.length();
        char[] chars = s.toCharArray();
        int placeValue = 0;
        for(int i=N-1; i>=0 ; i--){
            colNum += (s.charAt(i) - 'A' + 1)*Math.pow(26, placeValue++);
        }
        return colNum;
    }
}
