package Present;

import java.util.Scanner;
import java.util.Vector;

import Control.CIndex;
import Control.CLecture;
import Valueobject.VIndex;
import Valueobject.VLecture;

public class PLectureSelection {
		//index 
		private CIndex cIndex;
		public CLecture cLecture;
		
		public PLectureSelection() {
		cIndex = new CIndex();
		cLecture = new CLecture();
		}

		//index
	private String FindIndexFileName(String message, String parentFileName, Scanner keyboard) {
		
		System.out.println(message+" 코드를 선택하세요.");
		
		//return filename
		Vector<VIndex> vIndexVector = cIndex.getIndexVector(parentFileName);
		for (VIndex vIndex: vIndexVector) {
			vIndex.show();
		}
		
		//search code
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		int selection = -1;
		for (int i = 0; i < vIndexVector.size(); i++) {
            if (vIndexVector.get(i).getCode() == iCode) {
            	selection = i;
            }
		}
        String fileName = vIndexVector.get(selection).getFileName();
		return fileName;
	}
	
		//select lecture
	private VLecture FindLecture(String fileName,Scanner keyboard) {
		
		System.out.println("강좌 코드를 입력하세요.");
		
		//return lecture
		Vector<VLecture> vLectureVector = cLecture.getLectureVector(fileName);
		for (VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
		
		//search code
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		int selection = -1;
		for (int i = 0; i < vLectureVector.size(); i++) {
            if (vLectureVector.get(i).getCode() == iCode) {
            	selection = i;
            }
		}
		
		VLecture vLecture = vLectureVector.get(selection);
		return vLecture;
	}

	
	public VLecture selectLecture(Scanner keyboard) {
		String campusFileName = this.FindIndexFileName("캠퍼스","root", keyboard);
		String collegeFileName = this.FindIndexFileName("대학",campusFileName,keyboard);
		String departmentFileName = this.FindIndexFileName("학과",collegeFileName,keyboard);
		VLecture vLecture = this.FindLecture(departmentFileName, keyboard);
		return vLecture;
	}
}
