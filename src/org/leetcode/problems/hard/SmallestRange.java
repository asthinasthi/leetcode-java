package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.*;

public class SmallestRange {

    @Test
    public void test(){
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));

        int[] range = smallestRange(nums);
        System.out.print(range[0] + ", " + range[1]);
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        //sort the sorted list
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>((o1, o2) -> o1.val - o2.val);
        int max = 0;
        int[] next = new int[nums.size()];
        int X = 0;
        int Y = Integer.MAX_VALUE;
        int minRange = Y-X;

        // find mins in every list is all zeros
        // Load the min Heap
        for (int i = 0; i < nums.size() ; i++) {
            minHeap.add(new Element(i, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }

        X = minHeap.peek().val;
        Y = max;
        minRange = Y-X;
        // find X,Y which satisfy criteria
        // get the min arr idx & try to increase the min val
        Element minElement = minHeap.peek();

        Integer nextMinIdx = next[minElement.parentArrIdx]++;
        while (nextMinIdx < nums.get(minElement.parentArrIdx).size()){ //traverse until end of any list 1-->2-->3-->10 ...
            minHeap.poll(); // pop the top
            Integer nextVal = nums.get(minElement.parentArrIdx).get(nextMinIdx);
            max = Math.max(max, nextVal);
            Element nextElem = new Element(minElement.parentArrIdx, nextVal);
            minHeap.add(nextElem);
            minElement = minHeap.peek();

            if(max-minElement.val < minRange){
                X = minElement.val;
                Y = max;
                minRange = max - minElement.val;
            } else if(max-minElement.val  == minRange && minElement.val < X){
                X = minElement.val;
                Y = max;
            } else {

            }
            nextMinIdx = next[minElement.parentArrIdx]++;
        }
        return  new int[]{X,Y};
    }

    class Element {
        int parentArrIdx;
        int val;

        public Element(int parentArrIdx, int val){
            this.parentArrIdx = parentArrIdx;
            this.val = val;
        }
    }

    private void print(PriorityQueue<Element> heap){
        Object[] elements = heap.toArray();
        for (int i = 0; i < elements.length; i++) {
            System.out.print(((Element)elements[i]).val + ",");
        }
        System.out.println("");
    }
}
