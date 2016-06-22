/**
 * 
 */
package org.designpatterns.behavioral;

/**
 * @author amathad
 *
 */
public class BloombergStockObserver implements Observer {
	private double googPrice;
	private double aaplPrice;
	private double ibmPrice;
	private String observerName;
	private static double observerId;
	
	public BloombergStockObserver(String observerName, StockPublisher publisher){
		this.observerName = observerName;
		observerId++;
		publisher.register(this);
	}
	
	@Override
	public void updatePrices(double googPrice, double aaplPrice, double ibmPrice) {
		this.googPrice = googPrice;
		this.aaplPrice = aaplPrice;
		this.ibmPrice = ibmPrice;
		
		System.out.println();
		System.out.println(observerName  + "Observer ... ");
		System.out.println("Google: " + googPrice);
		System.out.println("Apple: " + aaplPrice);
		System.out.println("IBM: " + ibmPrice);
	}

}
