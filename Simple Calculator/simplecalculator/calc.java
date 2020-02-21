package simplecalculator;

public class calc implements ICalculator{
    public int add(int x,int y) {
    	
    	return x+y;
    }
    
    public float divide(int x,int y)throws RuntimeException{
    	float z=0;
    	if(y==0) {
    		throw new RuntimeException("Cannot divide by zero");
    	}
    	else {
    		z=(float)((x*1.0)/y);
    		return z;
    	}
    }
}
