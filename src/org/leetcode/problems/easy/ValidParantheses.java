package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.Stack;

public class ValidParantheses {

    @Test
    public void test(){
        String s = "())";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {

        Stack<String> stack = new Stack<>();

        int i=0;

        while(i<s.length()){
            String currStr = s.substring(i,i+1);
            if(stack.isEmpty()){
              stack.push(currStr);
            } else {
                String top = stack.peek();
                if(checkMatch(top, currStr)){
                    stack.pop();
                } else {
                    stack.push(currStr);
                }
            }
            i++;
        }

        return stack.isEmpty() ? true: false;
    }

    public boolean checkMatch(String top, String currStr){
        if(top.equals("(") && currStr.equals(")")){
            return true;
        } else if(top.equals("{") && currStr.equals("}")){
            return true;
        } else if(top.equals("[") && currStr.equals("]")){
            return true;
        } else {
            return false;
        }
    }
}
