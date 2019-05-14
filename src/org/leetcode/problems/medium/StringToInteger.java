package org.leetcode.problems.medium;

import org.junit.Test;

public class StringToInteger {

    @Test
    public void test(){
        String str = "4193 with words";
        str = "-91283472332";
        str = "+";
        str = "being words 234";
        str = " +-42";
        str = "3.14159";
        str = "+1";
        System.out.println(myAtoi(str));
    }

    /*
    * Handle white spaces
    * Handle plus minus
    * Handle ranges
    * Handle extra words
    * Handle before words. Space ok, Signs ok,
    * "   "
    * */
    public int myAtoi(String str) {

        int sign = 1;
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int signsCount = 0;
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];

            if(c == ' '){
                continue;
            }

            if(Character.isAlphabetic(c) || c == '.'){
                break;
            }

            if(c == '+' || c=='-'){
                signsCount++;
                if(signsCount == 1 && c=='-'){
                    sign = -1;
                } else if(c == '+') {
                } else {
                    break;
                }
            }

            if(Character.isDigit(c)){
                stringBuffer.append(c);
            }

        }

        //number conversion
        Double number = 0d;
        if(stringBuffer.length() >0){
            number = sign*Double.parseDouble(stringBuffer.toString());
        }

        if(number >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if(number <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else {
            return number.intValue();
        }
    }
}
