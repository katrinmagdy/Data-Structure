package simplecalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class exception {

	@Test
 public	void exceptiontest() {
		try {
		   calc junit1 =new calc();
		   junit1.divide(5, 0);
		    
		   fail();
	   }
		catch(RuntimeException e) {
			assertEquals("Cannot divide by zero",e.getMessage());
			
		}

}
}
