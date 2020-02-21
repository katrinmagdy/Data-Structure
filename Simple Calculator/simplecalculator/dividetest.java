package simplecalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class dividetest {

	@Test
 public	void divitest() {
		calc junitdivide =new calc();
		
		float result2=junitdivide.divide(5, 2);
		assertEquals(2.5,result2);
		
		float result3=junitdivide.divide(1,3);
		assertEquals(0.3333333432674408,result3);
		
		
	}

}
