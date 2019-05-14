package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.Stack;

public class BasicCalculatorII {

    @Test
    public void test(){
        String s = "2*(5+5*2)/3+(6/2+8)";
//        String s = "4/2+3";
        System.out.println(calculate(s));
    }

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;
        String prevMulDiv = "";
        char[] charArr = s.toCharArray();
        int holdingProd = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            if(Character.isDigit(charArr[i])){
                number = 10*number + (int)charArr[i]-'0';
            } else if(charArr[i] == '+'){
                if(holdingProd==Integer.MIN_VALUE){
                    result += sign*number;
                } else {
                    holdingProd = getLastOpResult(holdingProd, number, prevMulDiv);
                    result += sign*holdingProd;
                }
                sign = 1;
                number = 0;
                holdingProd = Integer.MIN_VALUE;
            } else if(charArr[i] == '-'){
                if(holdingProd==Integer.MIN_VALUE){
                    result += sign*number;
                } else {
                    holdingProd = getLastOpResult(holdingProd, number, prevMulDiv);
                    result += sign*holdingProd;
                }
                number = 0;
                sign = -1;
                holdingProd = Integer.MIN_VALUE;
            } else if(charArr[i] == '*'){ // 5 + 5*26*31
                holdingProd = holdingProd==Integer.MIN_VALUE? number: getLastOpResult(holdingProd, number, prevMulDiv);
                prevMulDiv = "*";
                number = 0;
            } else if(charArr[i] == '/'){
                holdingProd = holdingProd==Integer.MIN_VALUE? number: getLastOpResult(holdingProd, number, prevMulDiv);
                prevMulDiv = "/";
                number = 0;
            } else if(charArr[i] == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
            } else if(charArr[i] == ')'){
                result += stack.pop()*stack.pop();
                number = 0;
            }
        }

        if(holdingProd!=Integer.MIN_VALUE){
            holdingProd = getLastOpResult(holdingProd, number, prevMulDiv);
            result += sign*holdingProd;
            number = 0;
        }

        if(number != 0){
            result += sign*number;
        }
        return result;
    }

    private int getLastOpResult(int holdingProd, int number, String prevMulDiv){
        if(prevMulDiv.equals("/")){
            holdingProd /= number;
        } else {
            holdingProd *= number;
        }
        return holdingProd;
    }
}
