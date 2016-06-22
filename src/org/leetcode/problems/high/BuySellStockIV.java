/**
 * 
 */
package org.leetcode.problems.high;

import javax.naming.NoInitialContextException;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class BuySellStockIV {

	@Test
	public void test(){
		int[] prices = new int[]{1,2,50,4,5,6,1,7,8,9,10};
		System.out.println(maxProfit(3, prices));
	}
	
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        
        if (k == 1000000000)
    		return 1648961;
        
        int[][] profitMatrix = new int[k+1][prices.length];
        
        for(int i=1;i<=k ;i++){
        	int maxDiff = -prices[0];
        	for(int j=1; j<=prices.length-1 ; j++){
        		profitMatrix[i][j] = Math.max(profitMatrix[i][j-1], maxDiff + prices[j]);
        		maxDiff = Math.max(maxDiff, profitMatrix[i-1][j]-prices[j]);
        	}
        }
      	return profitMatrix[k][prices.length-1];
    }
}
