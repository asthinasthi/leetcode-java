package org.designpatterns.behavioral;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Random;

public class StockPriceGenerator implements Runnable{
	
	private StockPublisher publisher ;
	private String company;
	private double price ;
	
	public StockPriceGenerator(StockPublisher publisher, String company, double currPrice ){
		this.publisher = publisher;
		this.company = company;
		this.price = currPrice;
	}

	@Override
	public void run() {
		Calendar until = Calendar.getInstance(); 
		until.add(Calendar.SECOND, 25);
		while(Calendar.getInstance().before(until)){
			try {
				Thread.sleep(2000);
				double newPrice = price +  (Math.random()*0.06) - 0.03;
				DecimalFormat df = new DecimalFormat("#.##");
				if(company.equalsIgnoreCase("AAPL"))
					publisher.setAaplPrice(Double.valueOf(df.format(newPrice)));
				if(company.equalsIgnoreCase("GOOG"))
					publisher.setGoogPrice(Double.valueOf(df.format(newPrice)));
				if(company.equalsIgnoreCase("IBM"))
					publisher.setIbmPrice(Double.valueOf(df.format(newPrice)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
