package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    @Test
    public void test(){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(50);
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
    }

    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        this.leftMaxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //max top
            }
        });

        this.rightMinHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public void addNum(int num) {
        leftMaxHeap.add(num);
        rightMinHeap.add(leftMaxHeap.poll());

        if(leftMaxHeap.size() < rightMinHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        return leftMaxHeap.size() == rightMinHeap.size() ? (leftMaxHeap.peek() + rightMinHeap.peek())/2.0 : leftMaxHeap.peek();
    }
}
