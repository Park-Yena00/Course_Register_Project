package Present;

import java.util.Vector;

import Control.CMySugang;
import Valueobject.VLecture;

	public class PMySugang {
	private CMySugang cMySugang;
	private Vector<VLecture> vSugangVector;
	
	public PMySugang() {
		 cMySugang = new CMySugang();
		 this.vSugangVector = new Vector<VLecture>();
	}
	
	public void add(VLecture vLecture) {
		cMySugang.add(vLecture);
		vSugangVector.add(vLecture); // vSugangVector에 강좌 추가
		System.out.println("해당 강좌가 수강되었습니다.");
	}
	
	public void show() {
		System.out.println("수강신청 내역입니다.");
			cMySugang.Show();
		}
	
	public void remove(VLecture vLecture) {
		System.out.println("삭제할 강좌 코드를 입력하세요.");
		cMySugang.remove(); // 강좌 삭제
}
	}