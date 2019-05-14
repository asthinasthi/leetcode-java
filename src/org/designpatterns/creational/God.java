/**
 * 
 */
package org.designpatterns.creational;

/**
 * @author amathad
 *
 */
public class God {
	private static final God instance = new God();
	
	private God(){}
	
	public static God getInstance(){
		return instance;
	}
	
	public void willsIt(){
		System.out.println("God is one!!!");
	}
}

class God1{
	private static final God1 instance = new God1();

	private God1(){}

	public static God1 getInstance(){
		return instance;
	}
}