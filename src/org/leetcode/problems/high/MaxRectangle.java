package org.leetcode.problems.high;

import org.junit.Test;

import java.util.Stack;

public class MaxRectangle {

    @Test
    public void test() {

//        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//        char[][] matrix = new char[][]{{'1', '0','1','0','0'}, {'1','0','1','1','1'}};
//        char[][] matrix = new char[][]{{'1','0','1','1','1'}};
        char[][] matrix = new char[0][0];
        int maxArea = maximalRectangle(matrix);
        System.out.println(maxArea);
    }

    public int maxHist(int[][] heights) {
        int maxArea = 0;
        int R = heights.length;
        int C = heights[0].length;
        Stack<Integer> stack = new Stack<Integer>();
        int unstackBeginIdx = 0;
        for (int r = 0; r < R; r++) {
            int curr = 0;
            for (int c = 0; c < C; c++) {
                if (stack.isEmpty() || heights[r][c] >= heights[r][stack.peek()]) {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() && heights[r][c] < heights[r][stack.peek()]) { // pop until equal height
                        int topIdx = stack.pop();
                        int breadth = stack.isEmpty() ? c : c - stack.peek() - 1;
                        int height = heights[r][topIdx];
                        maxArea = Math.max(height * breadth, maxArea);
                    }
                    stack.push(c);
                }
            }
            while (!stack.isEmpty()) { // pop All
                int topIdx = stack.pop();
                int breadth = stack.isEmpty() ? C : C - stack.peek() - 1;
                int height = heights[r][topIdx];
                maxArea = Math.max(height * breadth, maxArea);
            }
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;

        int R = matrix.length;
        int C = matrix[0].length;
        int[][] heights = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == '1') {
                    heights[r][c] = 1;
                }
            }
        }

        for (int r = 1; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == '0') {
                    heights[r][c] = 0;
                } else {
                    heights[r][c] = heights[r - 1][c] + heights[r][c];
                }
            }
        }
        return maxHist(heights);
    }
}
