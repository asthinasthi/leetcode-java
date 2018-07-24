package org.leetcode.problems.medium;

import javax.swing.text.MaskFormatter;

import org.junit.Test;
import static org.junit.Assert.*;

public class BuySellStockII {

	@Test
	public void test(){
		int[] prices = new int[]{1,2,50,4,5,6,1,7,8,9,10};
//		int[] prices = new int[]{4,2,1};
		assertEquals(60, maxProfit(prices));
	}
	
    public int maxProfit(int[] prices) {
    	int profit = 0;
    	if(prices == null){
    		return 0;
    	}
    	if(prices.length <= 1)
    		return 0;
    	int localMinSoFar = prices[0];
    	
    	for(int i=1; i< prices.length;i++){
    		int dayPrice = prices[i];
    		localMinSoFar = Math.min(localMinSoFar, prices[i]);
    		if((prices[i] - localMinSoFar)>0){
    			profit += dayPrice - localMinSoFar;
    			localMinSoFar = dayPrice;
    		}
    	}
        return profit;
    }
    
    public int maxOneArray(int[] prices){
    	int maxProfitSoFar = 0;
    	int minSoFar = prices[0];
    	
    	for(int i=1; i<prices.length; i++){
    		minSoFar = Math.min(minSoFar, prices[i]);
    		maxProfitSoFar = Math.max(maxProfitSoFar, prices[i]-minSoFar);
    	}
    	return maxProfitSoFar;
    }
}
