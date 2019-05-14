package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.ArrayList;

public class SparseMatrixMultiplication {

    @Test
    public void test(){
//        int[][] A = new int[][]{{1,0,0},{-1,0,3}};
//        int[][] B = new int[][]{{7,0,0},{0,0,0},{0,0,1}};

        int[][] A = new int[][]{{1,-5}};
        int[][] B = new int[][]{{12},{-1}};

        int[][] product = multiply(A,B);
        System.out.println(product);
    }

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] product = new int[A.length][B[0].length];

        int cell = 0;
        for(int i=0; i<A.length; i++){
            int bCol = 0;
            while (bCol < B[0].length){
                for(int j=0; j<A[0].length; j++){
                    cell += A[i][j]*B[j][bCol];
                }
                product[i][bCol] = cell;
                cell = 0;
                bCol++;
            }
        }

        return product;
    }
}
