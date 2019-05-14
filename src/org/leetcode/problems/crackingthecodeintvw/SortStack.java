package org.leetcode.problems.crackingthecodeintvw;

import java.util.Stack;

public class SortStack {

    Stack<Integer> stack1 = new Stack<>(); //Unsorted
    Stack<Integer> stack2 = new Stack<>(); //Store in desc order

    public void sort(){

        while (!stack1.isEmpty()){
            Integer i = stack1.pop();

            if(stack2.isEmpty()){
                stack2.push(i);
            } else {
                while (stack2.peek() > i){
                    stack1.push(stack2.pop());
                }
                stack2.push(i);
            }

        }

    }
}
