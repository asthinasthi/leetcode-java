package org.leetcode.problems.crackingthecodeintvw;

import java.util.Stack;

/*
* FIFO
* Always store a reverse copy in s2
 */
public class MyQueue {

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public void add(Object o){
        stack1.push(o);
    }

    public Object remove(){
        if(!stack2.isEmpty()) return stack2.pop();

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
