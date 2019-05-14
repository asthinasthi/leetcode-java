package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    @Test
    public void test(){
//        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = new int[][]{{1}};
//        int[][] matrix = new int[][]{{1,2},{3,4}};
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//        List<Integer> result = spiralOrder(matrix);
        List<Integer> result = sprialOrderLeetCode(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList<>();
        int direction = 0; // 0 --> East  1 --> South 2 --> West 3 --> North
        int[][] visited = new int[matrix.length][matrix[0].length];
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int[] directionCounter = new int[]{1,1,1,1};
        List<Integer> trace = new ArrayList<>();
        int i=0,j=0;
        while(i<ROWS && j<COLS && visited[i][j] == 0){
            if(direction == 0){
                for ( ; j <= COLS-1-directionCounter[0]; j++) {
                    if(visited[i][j] == 0){
                        trace.add(matrix[i][j]);
                        visited[i][j]=1;
                    }
                }
                direction++;
                directionCounter[0]++;
            } else if(direction ==1){
                for ( ; i <= ROWS-1-directionCounter[1]; i++) {
                    if(visited[i][j] == 0){
                        trace.add(matrix[i][j]);
                        visited[i][j]=1;
                    }
                }
                direction++;
                directionCounter[1]++;
            } else if(direction == 2){
                for(;j>=directionCounter[2];j--){
                    if(visited[i][j] == 0){
                        trace.add(matrix[i][j]);
                        visited[i][j] =1;
                    }
                }
                direction++;
                directionCounter[2]++;
            } else if(direction == 3){
                for(;i>=directionCounter[3];i--){
                    if(visited[i][j] == 0){
                        trace.add(matrix[i][j]);
                        visited[i][j] =1;
                    }
                }
                direction = 0;
                directionCounter[3]++;
                i++;j++;
            }
        }
        if(ROWS == COLS && ROWS%2==1) trace.add(matrix[ROWS/2][COLS/2]);
        return trace;
    }

    public List<Integer> sprialOrderLeetCode(int[][] matrix){
        List<Integer> ret = new ArrayList<>();
        if(matrix.length == 0) return ret;
        
        int rowBegin=0,rowEnd=matrix.length-1, colBegin=0, colEnd=matrix[0].length-1;
        
        while (rowBegin<=rowEnd && colBegin<=colEnd){
            //Traverse Right
            for (int j = colBegin; j <= colEnd ; j++) {
                ret.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            //Down
            for (int i = rowBegin; i <=rowEnd ; i++) {
                ret.add(matrix[i][colEnd]);
            }
            colEnd--;

            //Left
            if(rowBegin<=rowEnd){
                for (int j = colEnd; j >= colBegin ; j--) {
                    ret.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            //Up
            if(colBegin<=colEnd){
                for (int i = rowEnd; i >= rowBegin ; i--) {
                    ret.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return ret;
    }
}
