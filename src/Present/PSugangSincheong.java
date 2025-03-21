package Present;
import java.util.Scanner;

import Valueobject.VLecture;
import Valueobject.VUserInfo;

//coderabbit review
	public class PSugangSincheong {
		private PLectureSelection pLectureSelection;
		private PBasket pBasket;
		private PMySugang pMySugang;
		private VLecture vLecture;
		
		public PSugangSincheong() {
			 pLectureSelection = new PLectureSelection();
			    pBasket = new PBasket();
			    pMySugang = new PMySugang();
		}
		
			
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		
		//gretting
		System.out.println(vUserInfo.getName() + "님, 안녕하세요");
		
		
		//menu
		boolean bLearning = true;
        VLecture vLecture = null;

		while(bLearning) {
		System.out.println("원하는 메뉴를 선택하세요.");
		System.out.println("0 강좌 선택, 1 미리담기내역, 2 강좌수강내역, 8 로그아웃, 9 끝내기");
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		
		switch(iCode) { 
			
			//select lecture
			case 0 :{
				vLecture = this.pLectureSelection.selectLecture(keyboard);
				System.out.println("1 미리담기, 2 강좌수강");
				sCode = keyboard.next();
				iCode = Integer.parseInt(sCode);
				switch(iCode) {
				case 1: this.pBasket.add(vLecture);
						System.out.println("선택한 강좌가 미리담기 내역에 저장되었습니다.");
						break;
				case 2: this.pMySugang.add(vLecture);
						System.out.println("선택한 강좌가 수강내역에 저장되었습니다.");
						break;
				}
			}
				break;
				
				
			//basket
			case 1:
				if(vLecture != null) {
				this.pBasket.show();
				System.out.println("0 수강 신청, 1 강좌 삭제,7 메뉴로 돌아가기, 8 로그아웃, 9 끝내기");
				sCode = keyboard.next();
				iCode = Integer.parseInt(sCode);
				
					switch(iCode) {
					case 0 : 
						this.pMySugang.add(vLecture);
						System.out.println("선택한 강좌가 수강내역에 저장되었습니다.");
						break;
					case 1 : 
						this.pBasket.remove();
						break;
						// return to main menu
					case 7:
					    System.out.println("메뉴로 돌아갑니다.");
					    continue;
					case 8:
		                 PLogin pLogin = new PLogin();
		                 pLogin.run(keyboard);
		                 bLearning = false;
		                 break;
					case 9 : 
						System.out.println("프로그램을 종료합니다.");
						bLearning = false;
						break;
					default:
						System.out.println("잘못된 입력입니다. 코드를 다시 입력하세요.");
						break;
						}
					vLecture = null;
					break;
				} else {
					System.out.println("미리담을 강좌를 선택해주세요.");
					break;
				}
				

			//sugang sincheong
			case 2: 
				if(pBasket != null) {
				this.pMySugang.show();
				System.out.println("0 강좌 삭제, 7 메뉴로 돌아가기, 8 로그아웃, 9 끝내기");
				sCode = keyboard.next();
				iCode = Integer.parseInt(sCode);
				
				switch (iCode){
				case 0:
					this.pMySugang.remove(vLecture);
					break;
					// return to main menu
				case 7:
				    System.out.println("메뉴로 돌아갑니다.");
				    continue; 
				case 8:
	                 PLogin pLogin = new PLogin();
	                 pLogin.run(keyboard);
	                 bLearning = false;
	                 break;
				case 9 :
					System.out.println("프로그램을 종료합니다.");
					bLearning = false;
					break;
				default:
					System.out.println("잘못된 입력입니다. 코드를 다시 입력하세요.");
					break;
				}
				}else {
					System.out.println("수강할 강좌를 선택해주세요.");
					break;
				}
	        	
			//logout
			case 8:
                 PLogin pLogin = new PLogin();
                 pLogin.run(keyboard);
                 bLearning = false;
                 break;
                 
			//finish
			case 9:
				System.out.println("프로그램을 종료합니다.");
				bLearning = false;
				break;
			
			//default
			default:
				System.out.println("잘못된 입력입니다. 코드를 다시 입력하세요.");
				break;
		}
	}
	}
	}
