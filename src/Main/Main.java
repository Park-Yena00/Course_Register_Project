package Main;

import java.util.Scanner;

import Present.PLogin;
import Present.PSugangSincheong;
import Valueobject.VUserInfo;

public class Main {
	public Main() {
	}
	public void run() {
		Scanner keyboard = new Scanner(System.in);
		PLogin plogin = new PLogin();
		VUserInfo vUserInfo = plogin.run(keyboard);
		if (vUserInfo != null) {
			PSugangSincheong pSugangsincheong = new PSugangSincheong();
			pSugangsincheong.run(vUserInfo, keyboard);
		}
		keyboard.close();
	}
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.run();
	}
	}
