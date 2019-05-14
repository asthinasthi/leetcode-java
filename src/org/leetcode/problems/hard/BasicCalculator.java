package org.leetcode.problems.hard;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import sun.misc.Regexp;

import java.util.Stack;
import java.util.regex.Pattern;

public class BasicCalculator {

    @Test
    public void testCalculator() {
//        String s = "(1+(45+5+2)-3)+(6+8)";
//        String s = "(1+(4+5+2)-3)+(6+8)";
//        String s = "1-(5)";
        String s = "(5-(1+(5)))";
        System.out.println(calculate(s));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Integer result = 0;
        Integer sign = 1;
        Integer number = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(charArr[i])){ //start building the nums
                number = 10*number + (int)(charArr[i]-'0');
            } else if(charArr[i] == '+'){
                result = result + sign*number;
                sign = 1;
                number = 0;
            } else if(charArr[i] == '-'){
                result = result + sign*number;
                sign = -1;
                number = 0;
            } else if(charArr[i] == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                number = 0;
                result = 0;
            } else if(charArr[i] == ')'){
                result = result + sign*number; //result inside braces
                result = stack.pop()*result; //multiply the braces elements by sign before the braces
                result = result + stack.pop(); //add to original running result
                number = 0;
            }
        }
        if(number!=0){
            result += sign*number;
        }
        return result;
    }
}
