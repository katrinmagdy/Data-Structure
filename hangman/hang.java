package eg.edu.alexu.csd.datastructure.hangman;

import java.io.*;
import java.util.*;
import java.lang.*;

public class hang implements IHangman{
	public String secret;
	public char[] secret2;
	private Scanner x;
	private String words1[]= new String[242];
	private int i=0;
	public int maximum1=6;
	public int wrongguess=0 ;
	
	
 public void setDictionary(String[] words) {
		System.arraycopy(words, 0, this.words1 , 0, words.length);
	}
 
	
   public String selectRandomSecretWord() {
	   Random r= new Random();
	   int random = r.nextInt(words1.length);
	   secret=words1[random];
	   
	   return secret;
	   
   }
   
   public String annonymus(String secret) {
	   secret2 = new char[secret.length()];
	   for(int i=0;i<secret.length();i++) {
		   secret2[i]='-';
	   }
	   String str =new String(secret2);
		return str;
   }

	
	public String guess(Character c) throws Exception{
	  char	cc= Character.toLowerCase(c);
	  int save=-1;
	  String y=null;
		if((cc>='a'&& cc<='z')) {
			for(int i=0;i<secret.length();i++) {
				if(cc==secret.charAt(i)) {
					save=i;
					secret2[save]=cc;
				}
			}
			if(save!=-1) {
				String str =new String(secret2);
				y=str;
			}
			else if(save==-1) {
				wrongguess++;
				if(wrongguess==maximum1) {
					throw new Exception("You lost");
				}
				else {
					String str =new String(secret2);
					y=str;
				}
			}
			return y;
		}
		else {
			throw new RuntimeException("Invalid character");
		}
	}
	
	public int wrong () {
		return wrongguess;
	}
	
	public void setMaxWrongGuesses(Integer max) {
		//the parameter max is the no of wrong guess made by the user throughout the game 
		//so that the (maximum1-max) is the no of remaining guesses
			System.out.printf("wrong guess allowed %d", maximum1-max);
	}
	
	public void openfile() {
		try {
			x = new Scanner(new File ("hangwords.txt"));
			
		}
		catch(Exception e) {
			System.out.println("Couldn't open file");
		}
	}
	
	public void readfile() {
		while(x.hasNext()) {
			String a =x.next();
			words1[i]=a;
			i++;
		}
		hang dictionary =new hang();
		dictionary.setDictionary(words1);
	 	
	}
	
	public void closefile() {
		x.close();
	}
	

}
