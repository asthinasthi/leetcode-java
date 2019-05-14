package org.leetcode.problems.crackingthecodeintvw;

import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.LinkedList;
import java.util.Queue;

/*
* Using single queue
* */
public class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    public void push(Integer x){
        queue.add(x);
        int size = queue.size();
        while (size > 1){
            queue.add(queue.remove());
            size--;
        }
    }

    public Integer pop(){
        return queue.remove();
    }

    public Integer top(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.size() == 0;
    }

    @Test
    public void test(){
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);

        Assert.assertEquals(3, myStack1.top().intValue());
        Assert.assertEquals(3, myStack1.pop().intValue());
        Assert.assertEquals(2, myStack1.top().intValue());

        myStack1.push(4);
        Assert.assertEquals(4, myStack1.top().intValue());
        Assert.assertEquals(4, myStack1.pop().intValue());
        Assert.assertEquals(2, myStack1.pop().intValue());
        Assert.assertEquals(1, myStack1.pop().intValue());

        myStack1.push(5);
        Assert.assertEquals(5, myStack1.top().intValue());
    }
}

/*
* Using 2 queues
* */

class MyStack1{
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(Integer x){
        queue1.add(x);
    }

    //return last elem of the queue
    public Integer pop(){
        int size = queue1.size();
        while (size > 1){
            queue2.add(queue1.remove());
            size--;
        }
        Integer top = queue1.remove();
        size = queue2.size();
        while (size > 0){
            queue1.add(queue2.remove());
            size--;
        }
        return top;
    }

    public Integer top(){
        int size = queue1.size();
        while (size > 1){
            queue2.add(queue1.remove());
            size--;
        }
        Integer top = queue1.remove();
        queue2.add(top);
        size = queue2.size();
        while (size > 0){
            queue1.add(queue2.remove());
            size--;
        }
        return top;
    }

    public boolean isEmpty(){
        return queue1.size() == 0;
    }
}

