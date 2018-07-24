/**
 * 
 */
package org.designpatterns.structural;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class Composite {

	@Test
	public void test() {
	}

	public interface Component{
		public void operation();
		public void add(Component component);
		public void remove(Component component);
		public Component getChild(int i);
	}
	
	public class Leaf implements Component{

		@Override
		public void operation() {
			System.out.println("Executing Leaf functions .... ");
		}

		@Override
		public void add(Component component) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void remove(Component component) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Component getChild(int i) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public class Composites implements Component{

		@Override
		public void operation() {
			System.out.println("Composite operations ...");			
		}

		@Override
		public void add(Component component) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void remove(Component component) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Component getChild(int i) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
