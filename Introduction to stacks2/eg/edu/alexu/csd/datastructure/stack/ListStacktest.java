package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ListStacktest {

	@Test
	/**
	 * A test to test the methods in ListStack
	 */
	public void stacktest() {
		
		ListStack p= new ListStack();
		
		p.push(1); p.push(2); p.push(3); p.push(4);
		
		//test the peek method
		assertEquals(4,p.peek());
		
		//test the pop method
		assertEquals(4,p.pop());
		assertEquals(3,p.pop());
		assertEquals(2,p.pop());
		
		//test the size method
		assertEquals(1,p.size());
		
		//test the isEmpty method
		assertEquals(false,p.isEmpty());
		
		p.pop();
		assertEquals(true,p.isEmpty());
		
		//test the exceptions
		//peek
		try {
			p.peek();
		}
		catch(RuntimeException e) {
			assertEquals("The Stack is Empty",e.getMessage());
		}
		//pop
		try {
			p.pop();
		}
		catch(RuntimeException e) {
			assertEquals("The Stack is Empty",e.getMessage());
		}
		
	}

}
