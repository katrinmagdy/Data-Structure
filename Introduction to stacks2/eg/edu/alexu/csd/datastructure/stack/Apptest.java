package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Apptest {
	
	@Test
	/**
	 * A test to test the infixtopostfix method
	 */
	public void infixtopostfixtest() {
         ExpressionEval  t =new  ExpressionEval();
		
		//to test the infixtopostfix method
		
		 String x ="1-(3*(-5))";      String result ="1 3 0 5 - * -";   String out =t.infixToPostfix(x);
		 assertEquals(result,out);
		 
		 x ="1-(3+-5)";       result ="1 3 0 5 - + -";    out =t.infixToPostfix(x);
		 assertEquals(result,out);
		 
		 x ="2*-5";       result ="2 0 5 - *";    out =t.infixToPostfix(x);
		 assertEquals(result,out);
		
		 x ="2 + 3 * 4";     result="2 3 4 * +";     out =t.infixToPostfix(x);
		 assertEquals(result,out);
		 
		 x ="a * (-b) + 5";     result="a 0 b - * 5 +";     out =t.infixToPostfix(x);
		 assertEquals(result,out);
		 
		 x ="(13 + (-20)) * 7";     result="13 0 20 - + 7 *";     out =t.infixToPostfix(x);
		 assertEquals(result,out);
		 
		 x ="a * b / c";     result="a b * c /";     out =t.infixToPostfix(x);
		 assertEquals(result,out);
		 
		 x ="(a / (b - c + d)) * (e - a) * c";     result="a b c - d + / e a - * c *";     out =t.infixToPostfix(x);
		 assertEquals(result,out);
		 
		 x ="a / b - c + d * e - a * c";     result="a b / c - d e * + a c * -";     out =t.infixToPostfix(x);
		 assertEquals(result,out);
		 
		 //to test the exceptions in the infixtopostfix method
		 
		 try {
			 t.infixToPostfix("1-(3*-5");
		}
		catch(RuntimeException e) {
			assertEquals("Invalid Expression: Missing Parentheses",e.getMessage());
		}
		
		try {
			 t.infixToPostfix("2 + 3  4");
		}
		catch(RuntimeException e) {
			assertEquals("Wrong Expression:Two numbers without an operator",e.getMessage());
		}
		
		try {
			t.infixToPostfix("a * b + ");
		}
		catch(RuntimeException e) {
			assertEquals("Wrong Expression: Cannot end with an operator",e.getMessage());
		}
		
		try {
			t.infixToPostfix("a * b ++ 5");
		}
		catch(RuntimeException e) {
			assertEquals("Wrong Expression:(++)",e.getMessage());
		}
		
		try {
			 t.infixToPostfix("a * b / c$");
		}
		catch(RuntimeException e) {
			assertEquals("Invalid Input",e.getMessage());
		}
		
		try {
			 t.infixToPostfix("a *+ b / c");
		}
		catch(RuntimeException e) {
			assertEquals("Wrong Expression:(+*)or(*+)",e.getMessage());
		}
		
		try {
			 t.infixToPostfix("a ** b / c");
		}
		catch(RuntimeException e) {
			assertEquals("Wrong Expression:(**)",e.getMessage());
		}
		
		try {
			 t.infixToPostfix("a / + b / c");
		}
		catch(RuntimeException e) {
			assertEquals("Wrong Expression:(+/)or(/+)",e.getMessage());
		}
		 
	}

}
