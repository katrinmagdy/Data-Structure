package eg.edu.alexu.csd.datastructure.stack;

public class ExpressionEval implements IExpressionEvaluator{
	ListStack s =new ListStack();
    int length;
    /**
     * evaluate the given expression into an array of strings
     * puts every operator and number in an array of strings
     * @param exp   given expression
     * @return array of string containing each element in the expression
     */
    public String[] evalstring(String exp) {
		String[] out =new String[exp.length()];
		int j=0;
		for(int i=0;i<exp.length();i++) {
			if(exp.charAt(i)=='+'||exp.charAt(i)=='-'||exp.charAt(i)=='*'||exp.charAt(i)=='/'||exp.charAt(i)=='('||exp.charAt(i)==')') {
				out[j]=Character.toString(exp.charAt(i));
				j++;
			}
			else if(Character.isDigit(exp.charAt(i))||(Character.isAlphabetic(exp.charAt(i)))) {
				if(i<(exp.length()-1)) {
					out[j]=Character.toString(exp.charAt(i));
					while(i<(exp.length()-1)){
						if((Character.isDigit(exp.charAt(i+1))||Character.isAlphabetic(exp.charAt(i+1)))) {
							out[j]=out[j]+Character.toString(exp.charAt(i+1));
							i++;
						}
						else {
							break;
						}
					}
					j++;
				}
				else {
					out[j]=Character.toString(exp.charAt(i));
					j++;
				}
			}
			else if(exp.charAt(i)!=' ') {
				throw new RuntimeException("Invalid Input");
			}
		}
		length=j;
		return out;
	}
    /**
     * check if every open parentheses is closed 
     * @param expression  given infix expression
     * @return false if any paren is missing
     *         true otherwise
     */
    public boolean check_the_parentheses(String expression) {
		String[] ex =evalstring(expression);
		ListStack s = new ListStack();
		for(int i=0;i<length;i++) {
			if(ex[i].equals("(")) {
				s.push(ex[i]);
			}
			else if(ex[i].equals(")")) {
				if(s.isEmpty()) {
					return false;
				}
				else {
					s.pop();
				}
			}
		}
		if(s.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
    
   
    /**
     * validate the infix expression
     * @param expression given infix expression
     */
    public void validateinfix(String expression) {
		String[] v =evalstring(expression);
		for(int i=0;i<length-1;i++) {
			if(v[i].equals("/")&&v[i+1].equals("/")) {
				throw new RuntimeException("Wrong Expression:(//)");
			}
			else if(v[i].equals("*")&&v[i+1].equals("*")) {
				throw new RuntimeException("Wrong Expression:(**)");
			}
			else if(v[i].equals("+")&&v[i+1].equals("+")) {
				throw new RuntimeException("Wrong Expression:(++)");
			}
			else if((Character.isDigit(v[i].charAt(0))||Character.isAlphabetic(v[i].charAt(0)))&&(Character.isDigit(v[i+1].charAt(0))||Character.isAlphabetic(v[i+1].charAt(0)))) {
				throw new RuntimeException("Wrong Expression:Two numbers without an operator");
			}
			else if((v[i].equals("+")&&v[i+1].equals("/"))||v[i].equals("/")&&v[i+1].equals("+")) {
				throw new RuntimeException("Wrong Expression:(+/)or(/+)");
			}
            else if((v[i].equals("+")&&v[i+1].equals("*"))||v[i].equals("*")&&v[i+1].equals("+")) {
            	throw new RuntimeException("Wrong Expression:(+*)or(*+)");
			}
            else if((v[i].equals("*")&&v[i+1].equals("/"))||v[i].equals("/")&&v[i+1].equals("*")) {
            	throw new RuntimeException("Wrong Expression:(*/)or(/*)");
			}
            else if(v[i].equals("-")&&v[i+1].equals("*")) {
            	throw new RuntimeException("Wrong Expression:(-*)");
            }
            else if(v[i].equals("-")&&v[i+1].equals("+")) {
            	throw new RuntimeException("Wrong Expression:(-+)");
            }
            else if(v[i].equals("-")&&v[i+1].equals("/")) {
            	throw new RuntimeException("Wrong Expression:(-/)");
            }
			
		}
		
		if(v[length-1].equals("+")||v[length-1].equals("-")||v[length-1].equals("*")||v[length-1].equals("/")) {
			throw new RuntimeException("Wrong Expression: Cannot end with an operator");
		}
		
	 }
    /**
     * validate the postfix expression for the evaluate function
     * @param expression given postfix expression
     */
    public void validatepostfix(String expression){
		String[] v =evalstring(expression);
		int countn=0;
		int counto=0;
		for(int i=0;i<length;i++) {
			if(v[i].equals("-")||v[i].equals("+")||v[i].equals("*")||v[i].equals("/")) {
				counto++;
			}
			else if(Character.isDigit(v[i].charAt(0))) {
				countn++;
			}
			else {
				throw new RuntimeException("Wrong postfix Expression");
			}
		}
		if(counto!=countn-1) {
			throw new RuntimeException("Wrong postfix Expression");
		}
	}
    /**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	* 
	* @param expression
	*       infix expression
	* @return postfix expression
	*/
    public String infixToPostfix(String expression) {
		String[] c =evalstring(expression);
		String out="";
		
		if(check_the_parentheses(expression)==false) {
			throw new RuntimeException("Invalid Expression: Missing Parentheses");
		}
		validateinfix(expression);
		
		for(int i=0;i<length;i++) {
			if(Character.isDigit(c[i].charAt(0))||(Character.isAlphabetic(c[i].charAt(0)))) {
				out =out+c[i]+" ";
			}
			else if(c[i].equals("+")||c[i].equals("-")||c[i].equals("*")||c[i].equals("/")) {
				while(true) {
					if(s.size()!=0) {
						String tem=(String)s.peek();
						if((tem.equals("*")||tem.equals("/"))) {
							if(c[i].equals("-")&&(c[i-1].equals("*")||c[i-1].equals("/"))) {
								out=out+"0"+" ";
								break;
							}
							else {
								out =out+(String)s.pop()+" ";
							}
						}
						else if(c[i].equals("+")||c[i].equals("-")) {
							if(tem.equals("+")||tem.equals("-")) {
								if(c[i].equals("-")&&(c[i-1].equals("-")||c[i-1].equals("+"))) {
									out=out+"0"+" ";
									break;
								}
								else {
									out =out+(String)s.pop()+" ";
								}
							}
							else {
								break;
							}
						}
						else {
							break;
						}
					}
					else {
						break;
					}
				}
				s.push(c[i]);
				
			}
			else if(c[i].equals("(")) {
				if(c[i+1].equals("-")&&(Character.isDigit(c[i+2].charAt(0))||(Character.isAlphabetic(c[i+2].charAt(0))))) {
					out=out+"0"+" ";
				}
				s.push(c[i]);
			}
			else if(c[i].equals(")")) {
				while(true) {
				String temp =(String)s.pop();
				if(!temp.equals("(")) {
					out =out+temp+" ";
				 }
				else {
					break;
				}
			  }
			}
		}
		
		while(s.size()>1) {
			out =out+(String)s.pop()+" ";
		}
		if(s.size()==1) {
			out =out+(String)s.pop();
		}

		return out;
	}
    /**
	* Evaluate a postfix numeric expression, with a single space separator
	*
	* @param expression
	*      postfix expression
	* @return the expression evaluated value
	*/
    public int evaluate(String expression) {
		
		
		ListStack stack =new ListStack();
		ListStack extra =new ListStack();
		
		String[] postfix = evalstring(expression);
		
		validatepostfix(expression);
		
		for(int i=length-1;i>=0;i--) {
			stack.push(postfix[i]);
		}
		while(stack.size()!=0) {
			String temp =(String)stack.pop();
			if(Character.isDigit(temp.charAt(0))) {
				float t=Float.parseFloat(temp);
				extra.push(t);
			}
			else if(temp.equals("+")) {
				if(extra.size()<2) {
					throw new RuntimeException("Cannot Evaluate: Wrong postfix Expression");
				}
				else {
					float y=(float)extra.pop();
					float x=(float)extra.pop();
					float result = x+y;
					extra.push(result);
				}
			}
			else if(temp.equals("-")) {
				if(extra.size()<2) {
					throw new RuntimeException("Cannot Evaluate: Wrong postfix Expression");
				}
				else {
				    float y=(float)extra.pop();
				    float x=(float)extra.pop();
				    float result = x-y;
				    extra.push(result);
				}
			}
			else if(temp.equals("*")) {
				if(extra.size()<2) {
					throw new RuntimeException("Cannot Evaluate: Wrong postfix Expression");
				}
				else {
					float y=(float)extra.pop();
					float x=(float)extra.pop();
					float result = x*y;
					extra.push(result);
				}
			}
			else if(temp.equals("/")) {
				if(extra.size()<2) {
					throw new RuntimeException("Cannot Evaluate: Wrong postfix Expression");
				}
				else {
					float y=(float)extra.pop();
					float x=(float)extra.pop();
					
					if(y==0) {
						throw new RuntimeException("Cannot divide by zero");
					}
					else {
						float result = x/y;
						extra.push(result);
					}
				}
			}
		}
		
		if(extra.size()!=1) {
			throw new RuntimeException("Cannot Evaluate: Wrong postfix Expression");
		}
		else {
			float result1 =(float)extra.pop();
			int finalresult=(int)result1;
			return finalresult;
		}
		
	}
   
}
