package org.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class StockPublisher implements Subject{

	private List<Observer> observers = new ArrayList<Observer>();
	private double googPrice;
	private double aaplPrice;
	private double ibmPrice;
	
	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		observers.remove(observers.indexOf(observer));
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: observers)
			observer.updatePrices(googPrice, aaplPrice, ibmPrice);
	}

	public double getGoogPrice() {
		return googPrice;
	}

	public void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
		notifyObservers();
	}

	public double getAaplPrice() {
		return aaplPrice;
	}

	public void setAaplPrice(double aaplPrice) {
		this.aaplPrice = aaplPrice;
		notifyObservers();
	}

	public double getIbmPrice() {
		return ibmPrice;
	}

	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObservers();
	}

	
}
