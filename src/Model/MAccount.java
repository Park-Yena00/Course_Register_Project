package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Valueobject.VLogin;
import Valueobject.VUserInfo;
//coderabbit review
	public class MAccount {

		public VUserInfo login(VLogin vLogin) {
			
			VUserInfo vUserInfo = null;
			
			try(Scanner account = new Scanner(new File("Account/account.txt"))) {
				
				while(account.hasNextLine()) {
				String line = account.nextLine();
				String[] tokens = line.split(" ");
				if(vLogin.getUserId().equals(tokens[0])) {
					if(vLogin.getPassword().equals(tokens[1])) {
					
					vUserInfo = new VUserInfo();
					vUserInfo.setName(tokens[2]);
					break;
					
					}
				}
				}account.close();
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			return vUserInfo;
			}
		}
