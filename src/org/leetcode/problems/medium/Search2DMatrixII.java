/**
 * 
 */
package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class Search2DMatrixII {

	@Test
	public void test() {
/*		int[][] matrix = {{1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}};*/
		int[][] matrix = {{5},{6}};
		int target = 6;
		
		System.out.println(searchMatrix(matrix, target));
		assertEquals(true, searchMatrix(matrix, target));
	}

    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW_LENGTH = matrix.length;
        int COL_LENGTH = matrix[0].length;
        
        int currRow = 0;
        int currCol = COL_LENGTH-1;
/*        if(COL_LENGTH == 1)
        	currRow = ROW_LENGTH-1;*/
        
        while(currRow >= 0 && currRow <= ROW_LENGTH-1
        		&& currCol >= 0 && currCol <= COL_LENGTH-1){
        	if(target == matrix[currRow][currCol]){
        		return true;
        	} else if(target < matrix[currRow][currCol]){
        		currCol--;
        	} else {
        		currRow++;
        	}
        }

        return false;
    }
}
