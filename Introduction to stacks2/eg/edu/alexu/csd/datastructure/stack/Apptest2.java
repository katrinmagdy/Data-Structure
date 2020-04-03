package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Apptest2 {

	@Test
	/**
	 * A test to test the evaluate method
	 */
	public void evaluatetest() {
		 ExpressionEval  t =new  ExpressionEval();
		
		//to test the evaluate method
		 
		 int v=t.evaluate("1 3 0 5 - * -");
		 assertEquals(16,v);
		 
		 v=t.evaluate("2 3 4 * +");
		 assertEquals(14,v);
		 
		 v=t.evaluate("13 20 + 7 *");
		 assertEquals(231,v);
		 
		 v=t.evaluate("64 70 * 10 /");
		 assertEquals(448,v);
		 
		 v=t.evaluate("200 90 100 - 20 + / 50 200 - * 2 *");
		 assertEquals(-6000,v);
		 
		//to test the exceptions in the evaluate method
			
			try {
				 t.evaluate("64 70 * 0 /");
			}
			catch(RuntimeException e) {
				assertEquals("Cannot divide by zero",e.getMessage());
			}
			
			try {
				 t.evaluate("1 3 0 5 - * ) -");
			}
			catch(RuntimeException e) {
				assertEquals("Wrong postfix Expression",e.getMessage());
			}
			
			try {
				 t.evaluate("2 3 4 * ");
			}
			catch(RuntimeException e) {
				assertEquals("Wrong postfix Expression",e.getMessage());
			}
			
			try {
				 t.evaluate("2 * 3 4  +");
			}
			catch(RuntimeException e) {
				assertEquals("Cannot Evaluate: Wrong postfix Expression",e.getMessage());
			}
			
			try {
				 t.evaluate("2 3 a * +");
			}
			catch(RuntimeException e) {
				assertEquals("Wrong postfix Expression",e.getMessage());
			}
		 
		 
	}

}
