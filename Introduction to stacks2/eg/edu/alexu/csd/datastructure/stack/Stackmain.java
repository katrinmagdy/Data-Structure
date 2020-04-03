package eg.edu.alexu.csd.datastructure.stack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Stackmain {
/**
 * main of the List based Stack
 * @param args not used
 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		ListStack stack = new ListStack();
		int x=0,size;
		String push;
		String pop;
		
		while(true) {
			System.out.println("=======================");
			System.out.println("Please choose an action");
			System.out.println("-----------------------");
			System.out.println("1- Push");
			System.out.println("2- Pop");
			System.out.println("3- Peek");
			System.out.println("4- Get size");
			System.out.println("5- Check if empty");
			System.out.println("=======================");
			
			if(s.hasNextInt()) {
				x=s.nextInt();
			}
			else if(s.hasNextLine()) {
				try {
					s.next();
				   x=s.nextInt();
				}
				catch(InputMismatchException m){
					System.out.println(m.getMessage());
				}
			}
			
			if(x==1) {
				System.out.println("Enter the Object you want to push to the stack");
				push=s.next();
				stack.push(push);
				System.out.println("the Object is pushed to the stack");
			}
			else if(x==2) {
				try {
					pop=(String)stack.pop();
					System.out.printf("the Object is : %s",pop);
					System.out.println();
				}
				catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}
			else if(x==3) {
				try {
					pop=(String)stack.peek();
					System.out.printf("the Object is : %s",pop);
					System.out.println();
				}
				catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}
			else if(x==4) {
				size=stack.size();
				System.out.printf("The size of the Stack is: %d",size);
				System.out.println();
			}
			else if(x==5) {
				if(stack.isEmpty()==true) {
					System.out.println("The Stack is Empty ");
				}
				else if(stack.isEmpty()==false) {
					System.out.println("The Stack is Not Empty ");
				}
			}
			else {
				System.out.println("Invalid Input");
			}
		}


	}

}
