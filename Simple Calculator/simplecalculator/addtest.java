package simplecalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class addtest {

	@Test
 public void add1test() {
		calc junitadd =new calc();
		
		int result=junitadd.add(100, 200);
		assertEquals(300,result);
		
		int result1=junitadd.add(5, -6);
		assertEquals(-1,result1);
		
		
		
	}

}
