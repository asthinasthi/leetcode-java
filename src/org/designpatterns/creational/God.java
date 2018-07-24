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
