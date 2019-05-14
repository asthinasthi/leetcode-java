package org.leetcode.problems.hard;

import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        {
            int maxArea = 0;
            Stack<Integer> idxStack = new Stack<Integer>();
            int i = 0;
            int tp;
            int area;

            while (i<heights.length){
                if(idxStack.isEmpty() || (heights[idxStack.peek()] <= heights[i])){
                    idxStack.push(i++);
                } else {
                    tp = idxStack.pop(); //remove the higher element
                    area = heights[tp]*(idxStack.isEmpty()?i: i - idxStack.peek() - 1);
                    maxArea = Math.max(area, maxArea);
                }
            }

            while (!idxStack.isEmpty()){
                tp = idxStack.pop(); //remove the higher element
                area = heights[tp]*(idxStack.isEmpty()?i: i - idxStack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }

            return maxArea;
        }
    }

}
