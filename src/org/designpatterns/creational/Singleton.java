/**
 * 
 */
package org.designpatterns.creational;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class Singleton {

	@Test
	public void test() {
		God.getInstance().willsIt();
	}
	
}


