/**
 * 
 */
package org.leetcode.problems.medium;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class Search2DMatrix {

	@Test
	public void test(){
		int[][] matrix ={{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
//		int[][] matrix = {{1}};
		System.out.println(searchMatrix(matrix, 23));
	}
	
	   public boolean searchMatrix(int[][] matrix, int target) {
		   int numOfRows = matrix.length;
		   int numOfCols = matrix[0].length;
		   int arrIdx = 0;
		   int[] arr = new int[numOfRows*numOfCols] ;
	        for(int i=0; i<matrix.length;i++)
	        	for(int j=0; j<matrix[i].length; j++)
	        		arr[arrIdx++] = matrix[i][j];
	        //binary Search
	        return binarySearch(arr, target);
	   }
	   
	   public boolean binarySearch(int[] arr, int target){
		   int low = 0;
		   int high = arr.length-1;
		   while(low <= high){
			   int mid = (low+high)/2;
			   if(arr[mid] == target){
				   return true;
			   } else if(target < arr[mid]){
				   high = mid-1;
			   } else {
				   low = mid+1;
			   }
		   }
		   return false;
	   }
}
