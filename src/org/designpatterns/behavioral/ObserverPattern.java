/**
 * 
 */
package org.designpatterns.behavioral;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class ObserverPattern {

	
	public static void main(String[] args) {
		StockPublisher publisher = new StockPublisher();
		
		BloombergStockObserver bloomNYSE = new BloombergStockObserver("NYSE", publisher);
		BloombergStockObserver bloomSF = new BloombergStockObserver("SF", publisher);
		publisher.setAaplPrice(0100l);
		publisher.setGoogPrice(250l);
		publisher.setIbmPrice(988l);
		
		Runnable googThread = new StockPriceGenerator(publisher, "GOOG", 500l);
		Runnable aaplThread = new StockPriceGenerator(publisher, "aapl", 566l);
		Runnable ibmThread = new StockPriceGenerator(publisher, "ibm", 250l);
		
		new Thread(googThread).start();
		new Thread(aaplThread).start();
		new Thread(ibmThread).start();
	}

}
