
public class StockMarket {

	public static void main(String[] args){
		int[] stockPrices = {3, 2, 3, 4, 1, 10};
		int lowestStockPriceSoFar = stockPrices[0];
		int maxProfitSoFar = 0;
		int currentProfit = 0;
		
		for(int i=0; i<stockPrices.length; i++){
			if(lowestStockPriceSoFar > stockPrices[i]){
				lowestStockPriceSoFar = stockPrices[i];
		}
		currentProfit = stockPrices[i] - lowestStockPriceSoFar;
		if(currentProfit > maxProfitSoFar){
			maxProfitSoFar = currentProfit;
		}
		System.out.println(maxProfitSoFar);	
		}
	}
}
