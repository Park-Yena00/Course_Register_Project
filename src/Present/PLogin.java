package Present;

import java.util.Scanner;

import Control.CFind;
import Control.CLogin;
import Model.MFind;
import Valueobject.VFindUserInfo;
import Valueobject.VLogin;
import Valueobject.VUserInfo;

public class PLogin {

    public VUserInfo run(Scanner keyboard) {

        boolean loginSuccess = false;
        boolean keepRunning = true;
        VUserInfo vUserInfo = null;
        VFindUserInfo vFindUserInfo = null;

        while (keepRunning) {
            System.out.println("메뉴를 선택하세요.");
            System.out.println("0 로그인, 1 아이디,비밀번호 찾기");
            String input = keyboard.next();
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 0: // 로그인
                    while (!loginSuccess) {
                        System.out.println("아이디를 입력하세요.");
                        String userId = keyboard.next();
                        System.out.println("비밀번호를 입력하세요.");
                        String password = keyboard.next();

                        // Generate value object VLogin
                        VLogin vLogin = new VLogin();
                        vLogin.setUserId(userId);
                        vLogin.setPassword(password);

                        // Pass VLogin to CLogin
                        CLogin cLogin = new CLogin();
                        vUserInfo = cLogin.login(vLogin);

                        if (vUserInfo == null) {
                            System.out.println("로그인에 실패했습니다. 아이디와 비밀번호를 다시 입력하세요.");
                        } else {
                            loginSuccess = true;
                        }
                    }
                    return vUserInfo;

                case 1: // 아이디&비밀번호 찾기
                    System.out.println("학번을 입력하세요.");
                    String studentNumber = keyboard.next();

                    // Generate value object VLogin
                    VLogin vLogin = new VLogin();
                    vLogin.setStudentnumber(studentNumber);

                    // Pass VLogin to CFind
                    CFind cFind = new CFind();
                    vFindUserInfo = cFind.FindUserInfo(vLogin);

                    if (vFindUserInfo == null) {
                        System.out.println("일치하는 정보가 없습니다. 다시 입력해주세요.");
                    } else {
                        System.out.println("아이디는 " + vFindUserInfo.getFinduserid() + " 입니다.");
                        System.out.println("비밀번호는 " + vFindUserInfo.getFindpasswd() + " 입니다.");

                        // Reset password
                        System.out.println("비밀번호를 변경하시겠습니까?");
                        System.out.println("1.yes 2.no");
                        String answer = keyboard.next();

                        if (answer.equals("1")) {
                            System.out.println("새로운 비밀번호를 생성하세요.");
                            String newPassword = keyboard.next();

                            // Save newPassword to account.txt
                            MFind mFind = new MFind();
                            mFind.setNewPassword(newPassword, vFindUserInfo.getFinduserid());
                            
                        } else if (answer.equals("2")) {
                            System.out.println("비밀번호 변경을 취소합니다.");
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                        }
                    }
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                    break;
            }
        }
		return vUserInfo;
    }
}
