package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorIII {


    @Test
    public void test(){

//        String s = "5+6-(8+(9-3))+56";
//        String s = "0";
        String s = "((   (   (   4-   2)+ ( 6+   10 )   )+ 1)   /(  (  (   7  +   9 )*   (   5*8)   )-   (  5 +  (   2   *   10   ) ) ) )";
//        String s = "1 + 1";
        System.out.println(calculate(s));
    }

    public int calculate(String s){
        if(s == null) return 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i <s.length() ; i++) {
            queue.add(s.charAt(i));
        }
        queue.offer('+');
        return calculateUtil(queue);
    }


    public int calculateUtil(Queue<Character> queue) {

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int number = 0;
        Character sign = '+';
        while (!queue.isEmpty()){
            Character c = queue.poll();
            if (Character.isDigit(c)) {
                number = 10 * number + (int)(c-'0');
            } else if(c.equals('(')){
                number = calculateUtil(queue);
            } else if(c.equals(')')){
                break;
            }

            if ((!Character.isDigit(c) && c != ' ')  ) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = c;
            }
        }
        for (Integer integer : stack) {
            res += integer;
        }
        return res;
    }
}
