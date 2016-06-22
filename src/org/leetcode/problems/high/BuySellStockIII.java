package org.leetcode.problems.high;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author amathad
 *
 */
public class BuySellStockIII {

	@Test
	public void test() {
		int[] prices = new int[]{1,2,50,4,5,6,1,7,8,9,10};
//		int[] prices = new int[]{1,2};
		System.out.println(maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
    	int maxProfit = 0;
    	int minSoFar = prices[0];
    	int[] maxProfitAhead = maxAhead(prices);
    	for(int i=1;i<=prices.length-1;i++){
    		minSoFar = Math.min(minSoFar, prices[i]);
    		int profit = prices[i]-minSoFar + maxProfitAhead[i];
    		maxProfit = Math.max(maxProfit, profit);
    	}
    	
    	return maxProfit;
    }
    
	public int[] maxAhead(int[] prices){
		int[] maxProfitAhead = new int[prices.length];
		int maxAhead = prices[prices.length-1];
		int profit = 0;
		for(int i=prices.length-2; i>0 ;i--){
			 profit = Math.max(profit, maxAhead-prices[i]);
			 maxProfitAhead[i] = profit;
			 maxAhead = Math.max(maxAhead, prices[i]);
		}
		return maxProfitAhead;
	}
	
    public int maxProfitSoFar(int low, int high, int[] prices){
    	int maxProfitSoFar = 0;
    	int minSoFar = prices[low];
    	for(int i=low+1; i<=high;i++){
    		minSoFar = Math.min(minSoFar, prices[i] );
    		int profit = prices[i] - minSoFar;
    		maxProfitSoFar = Math.max(maxProfitSoFar, profit);
    	}
    	return maxProfitSoFar;
    }
}
