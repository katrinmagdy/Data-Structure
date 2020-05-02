package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.Serializable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Contact implements IContact{
	public String email;
	public String password;public String userName;
	File file = new File("accounts//emails.txt");
	public boolean validateEmail() {
		if(email.isBlank()||password.isBlank()||userName.isBlank()) {
			return false;
		}
		try {
			file.createNewFile();
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}

	BufferedReader br ;
	try {
		br = new BufferedReader(new FileReader("accounts//emails.txt"));
		String line;
			while((line=br.readLine())!=null) {
				if(line.equals(email)==true) {
					return false;
				}
				br.readLine();br.readLine();//bec one line for password and one for user name
			}
		br.close();
	}catch(Exception e) {
		
	}
	try {
		
		FileOutputStream fos = new FileOutputStream("accounts//emails.txt",true);
		BufferedWriter f = new BufferedWriter(new OutputStreamWriter(fos));
		if(file.length()==0) {
			f.write(email);
			f.newLine();
			f.write(password);
			f.newLine();
			f.write(userName);
			f.close();
		}
		else {
			f.newLine();
			f.write(email);
			f.newLine();
			f.write(password);
			f.newLine();
			f.write(userName);
			f.close();
		}
		
		
	}catch(Exception e1) {
		
	}
	
	return true;
	}
	

}
