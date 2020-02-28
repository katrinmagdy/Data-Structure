package eg.edu.alexu.csd.datastructure.hangman;

import java.util.Scanner;

public class hangmain {

	public static void main(String[] args) {
		
		int max=6;
		int wrongguess;
		hang x =new hang();
		x.openfile();
		x.readfile();
		x.closefile();
		wrongguess=x.wrong();
		
		String secretword =new String();
		
		
		secretword = x.selectRandomSecretWord();
		String secretchar ;
		secretchar=x.annonymus(secretword);
		System.out.print(secretchar);
		System.out.println();
		
	while(wrongguess<max) {
		
		Scanner s=new Scanner(System.in);
		char c= s.next().charAt(0);
		
			try {
		secretchar = x.guess(c);
		wrongguess=x.wrong();
			if(secretchar.contentEquals(secretword)) {
				System.out.printf("%s \nYou won",secretword);
				break;
			}
			else {
			System.out.printf("%s \t ",secretchar);
			x.setMaxWrongGuesses(wrongguess);
			System.out.println();
			}
			
		}
		catch(RuntimeException e) {
			System.out.print(e.getMessage());
			System.out.println();
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			System.out.printf("\nThe word is %s",secretword);
			break;
		}
	  }
	}
}
