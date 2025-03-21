package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Valueobject.VFindUserInfo;
import Valueobject.VLogin;

	
//coderabbit review
public class MFind {

    private VFindUserInfo vFindUserInfo;
    private VLogin vLogin;
    private String[] tokens;

    //학번 비교와 아이디,비밀번호 찾기
    public VFindUserInfo InfoInput(VLogin vLogin) {
        this.vLogin = vLogin;

        try (Scanner finder = new Scanner(new File("Account/account.txt"))) {
            while (finder.hasNextLine()) {
                String line = finder.nextLine();
                tokens = line.split(" ");
                if (vLogin.getStudentnumber().equals(tokens[3])) {
                    vFindUserInfo = new VFindUserInfo();
                    vFindUserInfo.setFinduserid(tokens[0]);
                    vFindUserInfo.setFindpasswd(tokens[1]);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return vFindUserInfo;
    }

    public void setNewPassword(String newPassword, String userId) {
        try {
            // 파일 읽기
            File inputFile = new File("Account/account.txt");
            File tempFile = new File("Account/account_temp.txt");
            FileWriter writer = new FileWriter(tempFile);

            boolean passwordUpdated = false;

            try (Scanner scanner = new Scanner(inputFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] currentTokens = line.split(" ");

                    if (currentTokens.length >= 4 && userId.equals(currentTokens[0])) {
                        writer.write(currentTokens[0] + " " + newPassword + " " + currentTokens[2] + " " + currentTokens[3]);
                        passwordUpdated = true;
                    } else {
                        writer.write(line);
                    }
                    writer.write(System.lineSeparator());
                }
            }

            writer.close();

            // 기존 파일 삭제
            if (inputFile.delete()) {
                // 임시 파일을 원본 파일로 이름 변경
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("비밀번호 수정에 실패했습니다.");
                    return;
                }
            } else {
                System.out.println("비밀번호 수정에 실패했습니다.");
                return;
            }

            if (passwordUpdated) {
                System.out.println("비밀번호가 성공적으로 수정되었습니다.");
            } else {
                System.out.println("비밀번호 수정에 실패했습니다. 일치하는 정보가 없습니다.");
            }
        } catch (IOException e) {
            System.out.println("비밀번호 수정에 실패했습니다.");
        }
    }
}
