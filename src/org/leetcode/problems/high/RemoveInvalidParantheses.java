/*
* https://leetcode.com/problems/remove-invalid-parentheses/description/
* */

package org.leetcode.problems.high;

import org.junit.Test;
import sun.misc.Regexp;

import java.util.*;
import java.util.regex.Pattern;


public class RemoveInvalidParantheses {


    @Test
    public void test() {
//        String p = ".*[a-zA-Z].*";
//        System.out.println("(v)".matches(p));

//        String s = "(v)())()";
//        String s = "n";
//        String s = ")(";
//        String s = "x(";
//        String s = ")d))";
//        String s = "()";
//        String s = ")o(v(";
//        String s = ")))())((p((())a(())(";
//        String s = "()((())h()(()()()))((";
//        String s = "(a)())()";
//            String s = "n";
        String s = "()())()";
        List<String> result = removeInvalidParentheses(s);
        for (String k : result)
            System.out.println(k);
    }

    public List<String> removeInvalidParentheses(String s) {
        HashMap<String, Boolean> validityMap = new HashMap<>();
        HashMap<Integer, List<String>> successMap = new HashMap<>();

        if (isValid(s)) {
            List<String> res = new ArrayList<>();
            res.add(s);
            return res;
        }

        Stack<String> stack = new Stack<>();
        stack.push(s);
        Integer maxLength = 0;
        while (!stack.isEmpty()) {
            String stackStr = stack.pop();
            for (int i = 0; i < stackStr.length(); i++) {
                //drop only one element
                if (!isParantheses(stackStr.substring(i, i + 1))) {
                    continue;
                }

                String remaining = stackStr.substring(0, i) + stackStr.substring(i + 1);
                if (!validityMap.containsKey(remaining)) {
                    validityMap.put(remaining, isValid(remaining));
                    if (!validityMap.get(remaining)) {
                        stack.push(remaining);
                    } else {
                        maxLength = Math.max(maxLength, remaining.length());

                        if(successMap.containsKey(remaining.length())){
                            List<String> list1 = successMap.get(remaining.length());
                            list1.add(remaining);
                            successMap.put(remaining.length(), list1);
                        } else {
                            List<String> list2 = new ArrayList<>();
                            list2.add(remaining);
                            successMap.put(remaining.length(), list2);
                        }
                    }
                }
            }
        }


//        List<String> result = new ArrayList<>();
//
//        for (String key : successList) {
//            if (key.length() == maxLength) {
//                result.add(key);
//            }
//        }
        return successMap.get(maxLength);
    }

    public boolean isValid(String s) {

        if (s.isEmpty())
            return true;

        if (!s.contains("(") && !s.contains(")"))
            return true;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                if (!s.substring(i, i + 1).matches(".*[a-zA-Z].*"))
                    stack.push(s.substring(i, i + 1));
            } else {
                String top = stack.peek();
                if (top.equalsIgnoreCase("(") && s.substring(i, i + 1).equalsIgnoreCase(")")) {
                    stack.pop();
                } else {
                    if (!s.substring(i, i + 1).matches(".*[a-zA-Z].*"))
                        stack.push(s.substring(i, i + 1));
                }
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public boolean isParantheses(String c) {
        return c.equals("(") || c.equals(")");
    }

    public void printMap(HashMap<Integer, List<String>> map){
        for(Integer key: map.keySet()){
            System.out.println("Key: " + key);
            for(String s: map.get(key))
                System.out.println(s);
                System.out.println("*******************");
        }
    }

}
